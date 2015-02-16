package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.view.RestaurantVO;
import com.jdc.ygn.sql.BaseModel;

public class RestaurantModel extends BaseModel<Restaurant> {

	public RestaurantModel(Connection conn) {
		super(Restaurant.class, conn);
	}
	
	public List<RestaurantVO> getAllVO() {
		return null;
	}
	
	public List<RestaurantVO> search(String keyword) {
		return null;
	}

	public RestaurantVO findViewById(int id) {
		return null;
	}
}
