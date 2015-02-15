package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.jdc.ygn.sql.Column;
import com.jdc.ygn.sql.DateColumn;
import com.jdc.ygn.sql.DateType;
import com.jdc.ygn.sql.Id;

public class Restaurant implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id(autoIncrease=true)
	private int id;
	private String name;
	private String address;
	@Column("township_id")
	private int townshipId;
	private String homepage;
	private String description;
	private String email;
	
	@DateColumn(type=DateType.Timestamp)
	private Date creation;
	@DateColumn(type=DateType.Timestamp)
	private Date modification;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTownshipId() {
		return townshipId;
	}
	public void setTownshipId(int townshipId) {
		this.townshipId = townshipId;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Date getModification() {
		return modification;
	}
	public void setModification(Date modification) {
		this.modification = modification;
	}
	
	
}
