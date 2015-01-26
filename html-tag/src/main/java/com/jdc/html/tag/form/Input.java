package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Type;

public class Input extends TagBuilder {
	
	public static Input builder() {
		return new Input();
	}

	protected Input() {
		super(Type.input);
	}
	
	public Input type(InputType type) {
		super.attr("type", type.toString());
		return this;
	}
	
	@Override
	public Input id(String id) {
		return (Input) super.id(id);
	}
	
	@Override
	public Input styleClass(String str) {
		return (Input) super.styleClass(str);
	}
	
	public Input name(String name) {
		super.attr("name", name);
		return this;
	}
	
	public Input value(String value) {
		super.attr("value", value);
		return this;
	}
	
	@Override
	public Input attr(String key, String value) {
		return (Input) super.attr(key, value);
	}
	
	public Input align(Align align) {
		super.attr("align", align.toString());
		return this;
	}
	
	public Input alt(String text) {
		super.attr("alt", text);
		return this;
	}
	
	public Input placeholder(String text) {
		super.attr("placeholder", text);
		return this;
	}
	
	public Input readonly() {
		super.attr("readonly", null);
		return this;
	}

	public Input required() {
		super.attr("required", null);
		return this;
	}

}
