package com.jdc.ygn.mvc;

public class BaseUrl {

	private String baseUrl;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public BaseUrl(String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}

	public String url(String path) {
		return String.format("%s/%s", baseUrl, path);
	}
	
	public String jsp(String path) {
		return String.format("/view/%s.jsp", path);
	}
}
