package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Type;

public class Select extends TagBuilder {
	
	public static Select builder(String text) {
		return new Select(text);
	}

	protected Select(String text) {
		super(Type.select, text);
	}
	
	@Override
	public Select styleClass(String str) {
		return (Select) super.styleClass(str);
	}
	
	@Override
	public Select id(String id) {
		return (Select) super.id(id);
	}
	
	public Select name(String name) {
		attr("name", name);
		return this;
	}

}
