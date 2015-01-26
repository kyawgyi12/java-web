package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Type;

public class Textarea extends TagBuilder {

	public static Textarea builder() {
		return new Textarea(Type.textarea);
	}
	
	protected Textarea(Type type) {
		super(type, "");
	}
	
	@Override
	public Textarea styleClass(String str) {
		return (Textarea) super.styleClass(str);
	}
	
	@Override
	public Textarea id(String id) {
		return (Textarea) super.id(id);
	}
	
	public Textarea name(String name) {
		return (Textarea) attr("name", name);
	}
	
	public Textarea cols(Integer col) {
		super.attr("cols", col.toString());
		return this;
	}
	
	public Textarea rows(Integer rows) {
		super.attr("rows", rows.toString());
		return this;
	}
	
	public Textarea readonly() {
		super.attr("readonly", null);
		return this;
	}
	
	public Textarea required() {
		super.attr("required", null);
		return this;
	}

	public Textarea wrap(Wrap wrap) {
		super.attr("wrap", wrap.toString());
		return this;
	}

	
	public enum Wrap {
		hard, soft
	}
}
