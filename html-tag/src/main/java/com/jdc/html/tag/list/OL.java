package com.jdc.html.tag.list;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Tag;
import com.jdc.html.tag.Type;

public class OL extends TagBuilder {

	public static OL builder() {
		return new OL(Type.ol);
	}
	
	protected OL(Type type) {
		super(type);
	}
	
	@Override
	public OL styleClass(String str) {
		return (OL) super.styleClass(str);
	}

	@Override
	public OL child(Tag... tags) {
		return (OL) super.child(tags);
	}
}
