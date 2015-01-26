package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Type;


public class Option extends TagBuilder {
	
	public static Option builder(String text) {
		return new Option(Type.option, text);
	}

	protected Option(Type type, String text) {
		super(type, text);
	}
	
	@Override
	public Option id(String id) {
		return (Option) super.id(id);
	}

}
