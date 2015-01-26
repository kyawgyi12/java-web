package com.jdc.html.tag.list;

import com.jdc.html.tag.Tag;
import com.jdc.html.tag.Type;
import com.jdc.html.tag.BaseTag.TagBuilder;

public class UL extends TagBuilder {

	protected UL() {
		super(Type.ul);
	}
	
	@Override
	protected UL styleClass(String str) {
		return (UL) super.styleClass(str);
	}
	
	@Override
	public UL child(Tag... tags) {
		return (UL) super.child(tags);
	}

}
