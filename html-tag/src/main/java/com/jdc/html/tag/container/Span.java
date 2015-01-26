package com.jdc.html.tag.container;

import com.jdc.html.tag.Tag;
import com.jdc.html.tag.Type;
import com.jdc.html.tag.BaseTag.TagBuilder;

public class Span extends TagBuilder {

	protected Span(Type type) {
		super(Type.span);
	}

	public Span(String text) {
		super(Type.span, text);
	}
	
	@Override
	public Span child(Tag... tags) {
		return (Span) super.child(tags);
	}
	
	public Span child(TagBuilder... tags) {
		for (TagBuilder tagBuilder : tags) {
			super.child(tagBuilder.build());
		}
		return this;
	}
	
	
	@Override
	public Span attr(String key, String value) {
		return (Span) super.attr(key, value);
	}
}
