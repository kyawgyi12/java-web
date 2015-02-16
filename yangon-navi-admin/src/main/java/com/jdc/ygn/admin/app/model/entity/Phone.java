package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Id;

public class Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id(autoIncrease=true)
	private long id;
	private String phone;
	@Column("restaurant_id")
	private long restaurantId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public Phone() {
	}
	public Phone(int id, String phone, int restaurantId) {
		super();
		this.id = id;
		this.phone = phone;
		this.restaurantId = restaurantId;
	}

}
