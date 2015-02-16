package com.jdc.ygn.admin.app.model.entity;

import java.io.Serializable;

import com.jdc.ygn.sql.Id;

public class Township implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id(autoIncrease=true)
	private long id;

	private String name;
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
