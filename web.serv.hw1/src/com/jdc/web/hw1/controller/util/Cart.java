package com.jdc.web.hw1.controller.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<CartItem> items;
	
	public Cart() {
		items = Collections.synchronizedList(new ArrayList<>());
	}
	
	public synchronized void add(CartItem item) {
		items.add(item);
	}
	
	public synchronized void remove(CartItem item) {
		items.remove(item);
	}
	
	public synchronized List<CartItem> getItems() {
		return items;
	}
	
	public synchronized void removeAl() {
		items.clear();
	}
	
	public synchronized int getTotal() {
		return items.stream().mapToInt(a -> a.getTotalPrice()).sum();
	}
	

}
