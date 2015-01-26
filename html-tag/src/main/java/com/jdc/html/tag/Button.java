package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.form.Method;
import com.jdc.html.tag.form.Target;

public class Button extends TagBuilder {
	
	public static Button builder(String text) {
		return new Button(text);
	}

	protected Button(String text) {
		super(com.jdc.html.tag.Type.button, text);
	}

	@Override
	public TagBuilder styleClass(String str) {
		return super.styleClass(str);
	}
	
	public TagBuilder autofocus() {
		attr("autofocus", null);
		return this;
	}
	
	public TagBuilder disabled() {
		attr("disabled", null);
		return this;
	}
	
	public TagBuilder form(String form) {
		attr("form_id", form);
		return this;
	}
	
	public TagBuilder formaction(String action) {
		attr("formaction", action);
		return this;
	}
	
	public TagBuilder formenctype(String type) {
		attr("formenctype", type);
		return this;
	}
	
	public TagBuilder formmethod(Method method) {
		attr("formmethod", method.toString());
		return this;
	}
	
	public TagBuilder formtarget(Target target) {
		attr("formtarget", target.toString());
		return this;
	}

	public TagBuilder formtarget(String target) {
		attr("formtarget", target);
		return this;
	}
	
	public TagBuilder name(String name) {
		return this;
	}
	
	public TagBuilder type(Type type) {
		attr("type", type.toString());
		return this;
	}
	
	public TagBuilder value(String text) {
		super.text(text);
		return this;
	}
	
	public enum Type {
		button, reset, submit;
	}
}
