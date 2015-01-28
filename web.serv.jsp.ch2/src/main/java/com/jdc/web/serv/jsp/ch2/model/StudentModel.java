package com.jdc.web.serv.jsp.ch2.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private DataSource ds;

	public static StudentModel model(DataSource ds) {
		return new StudentModel(ds);
	}

	private StudentModel(DataSource ds) {
		this.ds = ds;
	}

	public Student findById(int id) {
		String sql = "select * from student where id = ?";
		Student s = null;

		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			s = new Student();

			while (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setMail(rs.getString("mail"));
				s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public int addStudent(Student s) {
		String sql = "insert into student(name, phone, mail, address) values "
				+ "(?, ?, ?, ?)";

		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, s.getName());
			stmt.setString(2, s.getPhone());
			stmt.setString(3, s.getMail());
			stmt.setString(4, s.getAddress());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Student> getAll() {
		String sql = "select * from student";
		List<Student> list = new ArrayList<>();

		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setMail(rs.getString("mail"));
				s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int update(Student s) {
		String sql = "update student set name =?, phone=?, mail=?, address=? where "
				+ "id = ?";
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, s.getName());
			stmt.setString(2, s.getPhone());
			stmt.setString(3, s.getMail());
			stmt.setString(4, s.getAddress());
			stmt.setInt(5, s.getId());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		String sql = "delete from student where id = ?";
		
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
