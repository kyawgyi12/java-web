package com.jdc.ygn.admin.app.view;

import java.util.List;

import com.jdc.ygn.admin.app.model.entity.Category;
import com.jdc.ygn.admin.app.model.entity.Restaurant;

public class CategoryVO {

	private Category category;
	private List<Restaurant> restaurants;
	
	public CategoryVO(Category category, List<Restaurant> restaurants) {
		super();
		this.category = category;
		this.restaurants = restaurants;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	
}
