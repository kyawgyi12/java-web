package com.jdc.ygn.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jdc.ygn.sql.SqlHelper;

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
				.prepareStatement(help.getInsertSql())) {
			help.setInsertValue(stmt, t);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				return help.setIdValue(t, rs.getObject(0));

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
	
	protected Connection getConnection() {
		return conn;
	}

}