package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Table;

@Table("restaurant_category")
public class RestaurantCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column("restaurant_id")
	private int restaurantId;
	@Column("category_id")
	private int categoryId;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public RestaurantCategory() {
	}
	public RestaurantCategory(int restaurantId, int categoryId) {
		super();
		this.restaurantId = restaurantId;
		this.categoryId = categoryId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + restaurantId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantCategory other = (RestaurantCategory) obj;
		if (categoryId != other.categoryId)
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		return true;
	}

}
