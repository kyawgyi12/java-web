package com.jdc.ygn.admin.app.model;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.model.entity.Township;
import com.jdc.ygn.admin.app.view.RestaurantVO;
import com.jdc.ygn.sql.BaseModel;

public class RestaurantModel extends BaseModel<Restaurant> {
	
	private final BaseModel<Township> tsModel;
	private final MenuModel menuModel;
	private final PhoneModel phoneModel;
	private final PhotoModel photoModel;
	
	private Function<Restaurant, RestaurantVO> converter;

	public RestaurantModel(Connection conn) {
		super(Restaurant.class, conn);
		menuModel = new MenuModel(conn);
		tsModel = new BaseModel<Township>(Township.class, conn);
		phoneModel = new PhoneModel(conn);
		photoModel = new PhotoModel(conn);
		
		converter = a -> {
			RestaurantVO vo = new RestaurantVO();
			vo.setRestaurant(a);
			// menu
			vo.setMenus(menuModel.findByRestaurant(a.getId()));
			// phones
			vo.setPhones(phoneModel.findByRestaurant(a.getId()));
			// photos
			vo.setPhotos(photoModel.findByRestaurant(a.getId()));
			// township
			vo.setTownship(tsModel.findById(a.getTownshipId()));
			return vo;
		};
	}

	public List<RestaurantVO> getAllVO() {
		return getAll().stream()
				.map(converter)
				.collect(Collectors.toList());
	}

	public List<RestaurantVO> search(String keyword) {
		return null;
	}

	public RestaurantVO findViewById(long id) {
		return converter.apply(findById(id));
	}
}
