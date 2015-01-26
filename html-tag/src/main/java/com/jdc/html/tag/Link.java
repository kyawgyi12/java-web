package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;

public class Link extends TagBuilder {
	
	public static Link builder() {
		return new Link();
	}

	private Link() {
		super(Type.link);
		attr("rel", "stylesheet");
		attr("type", "text/css");
	}

	public Link href(String href) {
		attr("href", href);
		return this;
	}
		
}
