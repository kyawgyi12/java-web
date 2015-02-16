package com.jdc.ygn.admin.app.model.entity;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Id;

public class Menu {
	
	@Id(autoIncrease=true)
	private long id;
	private String name;
	private long price;
	@Column("restaurant_id")
	private long restaurantId;
	@Column("photo_id")
	private long photoId;
	
	public Menu() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

}
