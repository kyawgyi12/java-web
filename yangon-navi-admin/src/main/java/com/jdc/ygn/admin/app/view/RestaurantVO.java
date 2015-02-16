package com.jdc.ygn.admin.app.view;

import java.io.Serializable;
import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Phone;
import com.jdc.ygn.admin.app.model.entity.Restaurant;
import com.jdc.ygn.admin.app.model.entity.Township;

public class RestaurantVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Restaurant restaurant;
	private List<Phone> phones;
	private Township township;
	private List<MenuVO> menus;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public Township getTownship() {
		return township;
	}
	public void setTownship(Township township) {
		this.township = township;
	}
	public List<MenuVO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuVO> menus) {
		this.menus = menus;
	}

}
