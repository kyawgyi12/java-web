package com.jdc.web.hw1.controller.util;

import java.io.Serializable;

import com.jdc.web.hw1.model.entity.Item;

public class CartItem implements Serializable{

	private static final long serialVersionUID = 1L;

	private Item item;
	private int count;
	private int totalPrice;
	
	public synchronized Item getItem() {
		return item;
	}
	public synchronized void setItem(Item item) {
		this.item = item;
		setTotalPrice(count * item.getPrice());
	}
	public synchronized int getCount() {
		return count;
	}
	public synchronized void setCount(int count) {
		this.count = count;
		if(null == item) {
			setTotalPrice(count * item.getPrice());
		}
	}
	public synchronized int getTotalPrice() {
		return totalPrice;
	}
	public synchronized void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public synchronized int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + totalPrice;
		return result;
	}
	@Override
	public synchronized boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (count != other.count)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}
	
}
