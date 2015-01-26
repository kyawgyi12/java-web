package com.jdc.html.tag.meta;

public enum CharSet {
	utf8("UTF-8"), iso("ISO-8859-1");
	
	String value;
	
	private CharSet(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
