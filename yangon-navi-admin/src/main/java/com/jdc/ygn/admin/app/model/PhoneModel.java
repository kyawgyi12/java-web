package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Phone;
import com.jdc.ygn.sql.BaseModel;

public class PhoneModel extends BaseModel<Phone> {

	public PhoneModel(Connection conn) {
		super(Phone.class, conn);
	}
	
	public List<Phone> findByRestaurant(long restaurantId) {
		
		String sql = "select * from phone where restaurant_id = ?";
		
		try(PreparedStatement stmt = connection().prepareStatement(sql)) {
			stmt.setLong(1, restaurantId);
			return helper().getObjects(stmt.executeQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
