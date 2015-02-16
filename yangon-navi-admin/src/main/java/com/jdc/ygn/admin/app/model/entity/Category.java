package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Id;

public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id(autoIncrease=true)
	private long id;
	private String name;
	
	public Category() {
	}
	
	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
