package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.form.Target;

public class A extends TagBuilder {
	
	public static A builder(String text, String href) {
		return new A(text, href);
	}

	private A(String text, String href) {
		super(Type.a, text);
		attr("hef", href);
	}
	
	public TagBuilder target(Target target) {
		attr("target", target.toString());
		return this;
	}
	
	public TagBuilder target(String target) {
		attr("target", target);
		return this;
	}

}
