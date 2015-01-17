package com.jdc.web.serv.ch2.ep5;

import java.io.Serializable;

public class Counter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int count;
	
	public void countUp() {
		count ++;
	}
	
	public int getCount() {
		return count;
	}

}
