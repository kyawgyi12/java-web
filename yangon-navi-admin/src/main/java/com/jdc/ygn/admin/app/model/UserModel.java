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
				User user = new User();
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
