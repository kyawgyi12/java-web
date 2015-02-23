package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Category;
import com.jdc.ygn.sql.BaseModel;

public class CategoryModel extends BaseModel<Category> {

	public CategoryModel(Connection conn) {
		super(Category.class, conn);
	}
	
	public List<Category> findByName(String name) {
		String sql = "select * from category where name = ?";
		try (PreparedStatement stmt = connection().prepareStatement(sql)) {
			stmt.setString(1, name);
			return getObjects(stmt.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
 	}

}
