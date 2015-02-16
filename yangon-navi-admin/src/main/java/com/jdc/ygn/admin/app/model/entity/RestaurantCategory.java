package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Table;

@Table("restaurant_category")
public class RestaurantCategory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column("restaurant_id")
	private long restaurantId;
	@Column("category_id")
	private long categoryId;
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

}
