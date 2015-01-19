package com.jdc.web.hw1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Model<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<T> list;
	
	public Model() {
		list = Collections.synchronizedList(new ArrayList<>());
	}
	
	public synchronized void add(T t) {
		list.add(t);
	}
	
	public synchronized void update(T oldItem, T newItem) {
		list.remove(oldItem);
		list.add(newItem);
	}
	
	public abstract T findById(int id);
	
	public synchronized List<T> getAll() {
		return list;
	}
	
	public synchronized void delete(T t) {
		list.remove(t);
	}
	
	protected void addAll(List<T> list) {
		this.list.addAll(list);
	}
	
	@SuppressWarnings("unchecked")
	public static<T> Model<T> getModel(Class<T> entity, String path) {
		Model<T> model = null;
		
		switch(entity.getSimpleName()) {
		
		case "Item":
			model = (Model<T>) new ItemModel(path);
			break;
		
		case "User":
			model = (Model<T>) new UserModel(path);
			break;
			
		case "SellItem":
			model = (Model<T>) new SellItemModel();
			break;
			
		default:
			break;
		}
		
		return model;
	}

}
