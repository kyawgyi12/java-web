package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.EnumType;
import com.jdc.ygn.sql.Id;
import com.jdc.ygn.sql.PhotoType;

public class Photo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id(autoIncrease=true)
	private long id;
	@EnumType
	private PhotoType type;

	private String photo;
	@Column("restaurant_id")
	private long restaurantId;
	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PhotoType getType() {
		return type;
	}
	public void setType(PhotoType type) {
		this.type = type;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public Photo() {
	}

	public Photo(int id, PhotoType type, String photo, int restaurantId) {
		super();
		this.id = id;
		this.type = type;
		this.photo = photo;
		this.restaurantId = restaurantId;
	}

}
