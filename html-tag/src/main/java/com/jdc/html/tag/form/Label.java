package com.jdc.html.tag.form;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Type;

public class Label extends TagBuilder {
	
	public static Label builder(String text) {
		return new Label(Type.label, text);
	}

	protected Label(Type type, String text) {
		super(type, text);
	}
	
	@Override
	public Label styleClass(String str) {
		return (Label) super.styleClass(str);
	}
	
	public Label form(String form) {
		attr("form", form);
		return this;
	}

	public Label lbFor(String lbFor) {
		attr("for", lbFor);
		return this;
	}
}
