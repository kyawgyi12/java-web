package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.Id;

public class Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id(autoIncrease=true)
	private int id;
	private String phone;
	@Column("restaurant_id")
	private int restaurantId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Phone other = (Phone) obj;
		if (id != other.id)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		return true;
	}

}
