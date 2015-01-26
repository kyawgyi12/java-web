package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;

public class Heading extends TagBuilder {
	
	public static Heading h1(String text) {
		return new Heading(Type.h1, text);
	}
	
	public static Heading h2(String text) {
		return new Heading(Type.h2, text);
	}
	
	public static Heading h3(String text) {
		return new Heading(Type.h3, text);
	}

	public static Heading h4(String text) {
		return new Heading(Type.h4, text);
	}

	public static Heading h5(String text) {
		return new Heading(Type.h5, text);
	}

	public static Heading h6(String text) {
		return new Heading(Type.h6, text);
	}

	protected Heading(Type type, String text) {
		super(type, text);
	}
	
	@Override
	public Heading styleClass(String str) {
		return (Heading) super.styleClass(str);
	}

	@Override
	public Heading child(Tag... tags) {
		return (Heading) super.child(tags);
	}
	
	public Heading child(TagBuilder ... builders) {
		for (TagBuilder b : builders) {
			super.child(b.build());
		}
		return this;
	}

	@Override
	public Heading attr(String key, String value) {
		return (Heading) super.attr(key, value);
	}
}
