package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdc.ygn.admin.app.model.entity.User;
import com.jdc.ygn.sql.BaseModel;

public class UserModel extends BaseModel<User> {

	public UserModel(Connection conn) {
		super(User.class, conn);
	}
	
	public User getUser(String loginId, String pass) {
		
		String sql = "select * from user where name = ? and password= ?";
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setString(1, loginId);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
