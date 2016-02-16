package com.jdc.serv4;

import java.io.Serializable;

public class Counter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public Counter() {
	}
	
	public Counter(String val) {
		if(null != val && !val.isEmpty()) {
			count = Integer.valueOf(val);
		}
	}
	
	public void countUp() {
		count++;
	}
	
	@Override
	public String toString() {
		return String.valueOf(count);
	}

}
