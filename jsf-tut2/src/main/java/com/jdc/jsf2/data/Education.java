package com.jdc.jsf2.data;

public enum Education {
	
	HighSchool("High School"), 
	College("College"), 
	Master("Master Degree");
	
	private String value;

	private Education(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
