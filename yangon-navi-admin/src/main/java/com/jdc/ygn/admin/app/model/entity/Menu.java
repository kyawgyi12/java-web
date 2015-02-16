package com.jdc.ygn.admin.app.model.entity;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Id;

public class Menu {
	
	@Id(autoIncrease=true)
	private int id;
	private String name;
	private int price;
	@Column("restaurant_id")
	private int restaurantId;
	@Column("photo_id")
	private int photoId;
	
	public Menu() {
	}
	
	public Menu(int id, String name, int price, int restaurantId, int photoId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.restaurantId = restaurantId;
		this.photoId = photoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

}
