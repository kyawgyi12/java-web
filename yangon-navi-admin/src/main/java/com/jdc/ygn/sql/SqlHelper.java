package com.jdc.ygn.sql;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class SqlHelper<T> {

	private Class<T> type;
	private List<Field> insertColumns;
	private List<Field> idColumns;

	private static final String INSERT = "insert into %s (%s) values (%s)";
	private static final String DELETE = "delete from %s where %s";
	private static final String UPDATE = "update %s set %s where %s";
	private static final String SELECT_ALL = "select * from %s where 1=1";
	private static final String SELECT_WITH_ID = "select * from %s where %s";

	public SqlHelper(Class<T> type) {
		super();
		this.type = type;

		insertColumns = new ArrayList<>();
		idColumns = new ArrayList<>();

		for (Field f : this.type.getDeclaredFields()) {
			if (!f.getName().equals("serialVersionUID")) {
				Id id = f.getDeclaredAnnotation(Id.class);
				if (null == id || !id.autoIncrease()) {
					insertColumns.add(f);
				}

				if (null != id) {
					idColumns.add(f);
				}
			}
		}
	}

	public String getInsertSql() {
		return String.format(INSERT, getTableName(), getColumns(), getParams());
	}

	public String getUpdateSql() {
		return String.format(UPDATE, getTableName(), getSetParams(), getIds());
	}

	public String getDeleteSql() {
		return String.format(DELETE, getTableName(), getIds());
	}

	public String getSelectAllSql() {
		return String.format(SELECT_ALL, getTableName());
	}

	public String getFindByIdSql() {
		return String.format(SELECT_WITH_ID, getTableName(), getIds());
	}

	public void setInsertValue(PreparedStatement stmt, T t)
			throws SerialException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		for (int i = 0; i < insertColumns.size();) {
			Field f = insertColumns.get(i);
			stmt.setObject(++i, getSqlType(f, t));
		}
	}

	public void setUpdateValue(PreparedStatement stmt, T t)
			throws SerialException, IllegalArgumentException, IllegalAccessException, SQLException {
		int index = 0;
		
		for(Field f : insertColumns) {
			stmt.setObject(++index, getSqlType(f, t));
		}
		
		for(Field f : idColumns) {
			stmt.setObject(++index, getSqlType(f, t));
		}

	}

	public void setDeleteValue(PreparedStatement stmt, T t)
			throws IllegalArgumentException, IllegalAccessException,
			SerialException, SQLException {
		this.setIdValue(stmt, t);
	}

	public void setIdValue(PreparedStatement stmt, T t)
			throws IllegalArgumentException, IllegalAccessException,
			SerialException, SQLException {
		for (int i = 0; i < idColumns.size();) {
			Field f = idColumns.get(i);
			stmt.setObject(++i, getSqlType(f, t));
		}
	}

	public T setIdValue(T t, Object id) throws IllegalArgumentException,
			IllegalAccessException {
		for (Field f : type.getDeclaredFields()) {
			f.setAccessible(true);

			Id col = f.getDeclaredAnnotation(Id.class);

			if (null != col)
				f.set(t, id);
		}
		return t;
	}

	public T getObject(ResultSet res) {
		try {
			T t = type.newInstance();
			for (Field f : type.getDeclaredFields()) {
				f.setAccessible(true);
				String colName = f.getName();
				
				if("serialVersionUID".equals(colName))
					continue;
				
				Column col = f.getDeclaredAnnotation(Column.class);

				if (null != col)
					colName = col.value();

				f.set(t, res.getObject(colName));
			}

			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> getObjects(ResultSet res) throws SQLException {
		List<T> list = new ArrayList<>();
		while (res.next()) {
			list.add(getObject(res));
		}
		return list;
	}

	private Object getSqlType(Field f, T t) throws SerialException,
			IllegalArgumentException, IllegalAccessException, SQLException {
		f.setAccessible(true);
		Object obj = null;
		// blob
		BlobColumn blCol = f.getDeclaredAnnotation(BlobColumn.class);
		// date
		DateColumn dtCol = f.getDeclaredAnnotation(DateColumn.class);
		// enum
		EnumType enCol = f.getDeclaredAnnotation(EnumType.class);

		if (null != blCol) {
			obj = new SerialBlob((byte[]) f.get(t));
		} else if (null != dtCol) {
			DateType dt = dtCol.type();
			Date d = (Date) f.get(t);
			if(dt.equals(DateType.Timestamp)) {
				obj = new java.sql.Date(d.getTime());
			} else {
				obj = new Timestamp(d.getTime());
			}
		} else if (null != enCol) {
			Field [] fs = f.getClass().getEnumConstants();
			for(int i=0; i < fs.length; i++) {
				if(fs[i].equals(f.get(t))) {
					obj = i;
				}
			}
		} else {
			obj = f.get(t);
		}
		return obj;
	}

	private Object getSetParams() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < insertColumns.size(); i++) {
			Field f = insertColumns.get(i);
			String name = f.getName().toLowerCase();
			Column col = f.getDeclaredAnnotation(Column.class);

			if (null != col) {
				name = col.value();
			}

			if (i > 0) {
				sb.append(", ");
			}

			sb.append(name).append(" = ").append("?");
		}
		return sb.toString();
	}

	private Object getIds() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < idColumns.size(); i++) {
			Field f = idColumns.get(i);
			String name = f.getName().toLowerCase();
			Column col = f.getDeclaredAnnotation(Column.class);

			if (null != col) {
				name = col.value();
			}

			if (i > 0) {
				sb.append("and ");
			}

			sb.append(name).append(" = ").append("?");
		}
		return sb.toString();
	}

	private Object getParams() {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < insertColumns.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}

			sb.append("?");
		}
		return sb.toString();
	}

	private Object getColumns() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < insertColumns.size(); i++) {

			Field f = insertColumns.get(i);
			String name = f.getName().toLowerCase();
			Column col = f.getDeclaredAnnotation(Column.class);

			if (null != col) {
				name = col.value();
			}

			if (i > 0) {
				sb.append(", ");
			}

			sb.append(name);
		}
		return sb.toString();
	}

	private Object getTableName() {
		String name = type.getSimpleName().toLowerCase();

		Table t = type.getDeclaredAnnotation(Table.class);
		if (null != t) {
			name = t.value();
		}

		return name;
	}

}
