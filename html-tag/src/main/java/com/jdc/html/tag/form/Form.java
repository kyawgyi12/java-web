package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Tag;
import com.jdc.html.tag.Type;

public class Form extends TagBuilder {

	public static Form builder() {
		return new Form();
	}
	
	protected Form() {
		super(Type.form);
	}
	
	@Override
	public Form styleClass(String str) {
		return (Form) super.styleClass(str);
	}
	
	public Form method(Method method) {
		super.attr("method", method.toString());
		return this;
	}
	
	public Form target(Target target) {
		super.attr("target", target.toString());
		return this;
	}

	@Override
	public Form id(String id) {
		return (Form) super.id(id);
	}
	
	public Form action(String action) {
		super.attr("action", action);
		return this;
	}
	
	@Override
	public Form child(Tag... tags) {
		return (Form) super.child(tags);
	}
	
	@Override
	public Form attr(String key, String value) {
		return (Form) super.attr(key, value);
	}
}
