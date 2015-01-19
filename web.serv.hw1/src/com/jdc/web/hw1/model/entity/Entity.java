package com.jdc.web.hw1.model.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected int id;
	
	public Entity() {
		setId();
	}
	
	protected abstract void setId();
	
	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
