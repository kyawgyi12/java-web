package com.jdc.jsf2.data;

public enum Course {
	
	SE("Java SE"), 
	WEB("Java Web"), 
	EE("Java EE"), 
	SPRING("Spring Framework"), 
	ANDROID("Android");
	
	private String name;

	private Course(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
