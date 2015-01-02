package com.jdc.web.ch3.ep2.util;

import java.io.Serializable;

public class Counter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public synchronized void countUp() {
		count ++;
	}
	
	public synchronized int getCount() {
		return count;
	}

}
