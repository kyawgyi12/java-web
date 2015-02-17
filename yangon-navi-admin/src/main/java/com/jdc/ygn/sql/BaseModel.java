package com.jdc.ygn.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BaseModel<T> {

	private Connection conn;
	private SqlHelper<T> help;

	public BaseModel(Class<T> type, Connection conn) {
		super();
		this.conn = conn;
		help = new SqlHelper<T>(type);
	}

	public final T insert(T t) {
		try (PreparedStatement stmt = conn
				.prepareStatement(help.getInsertSql(), Statement.RETURN_GENERATED_KEYS)) {
			help.setInsertValue(stmt, t);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				return help.setIdValue(t, rs.getObject(1));

		} catch (IllegalArgumentException | IllegalAccessException
				| SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public T findById(Object id) {
		try (PreparedStatement stmt = conn.prepareStatement(help
				.getFindByIdSql())) {
			stmt.setObject(1, id);

			ResultSet rs = stmt.executeQuery();

			List<T> list = help.getObjects(rs);

			if (list.size() > 0)
				return list.get(0);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int update(T t) {

		try (PreparedStatement stmt = conn
				.prepareStatement(help.getUpdateSql())) {
			help.setUpdateValue(stmt, t);
			return stmt.executeUpdate();
		} catch (SQLException | IllegalArgumentException
				| IllegalAccessException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int delete(Object id) {
		try (PreparedStatement stmt = conn
				.prepareStatement(help.getDeleteSql())) {
			stmt.setObject(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<T> getAll() {
		try (PreparedStatement stmt = conn.prepareStatement(help
				.getSelectAllSql())) {
			return help.getObjects(stmt.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected Connection connection() {
		return conn;
	}
	
	protected SqlHelper<T> helper() {
		return this.help;
	}

}