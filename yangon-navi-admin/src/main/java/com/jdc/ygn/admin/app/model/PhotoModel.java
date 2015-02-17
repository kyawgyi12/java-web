package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Photo;
import com.jdc.ygn.sql.BaseModel;

public class PhotoModel extends BaseModel<Photo> {

	public PhotoModel(Connection conn) {
		super(Photo.class, conn);
	}
	
	public List<Photo> findByRestaurant(long restaurantId) {
		String sql = "select * from photo where type <> 2 and restaurant_id = ?";
		
		try(PreparedStatement stmt = connection().prepareStatement(sql)) {
			stmt.setLong(1, restaurantId);
			return helper().getObjects(stmt.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
