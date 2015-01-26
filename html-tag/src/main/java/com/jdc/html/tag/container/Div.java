package com.jdc.html.tag.container;

import com.jdc.html.tag.BaseTag.TagBuilder;
import com.jdc.html.tag.Tag;
import com.jdc.html.tag.Type;

public class Div extends TagBuilder {
	
	public static Div builder() {
		return new Div();
	}

	private Div() {
		super(Type.div);
	}
	
	@Override
	public Div styleClass(String str) {
		super.styleClass(str);
		return this;
	}
	
	@Override
	public Div id(String id) {
		super.id(id);
		return this;
	}
	
	public Div align(Align align) {
		attr("align", align.toString());
		return this;
	}
	
	@Override
	public Div child(Tag... tags) {
		super.child(tags);
		return this;
	}
	
	public Div child(TagBuilder ... builders) {
		for (TagBuilder tagBuilder : builders) {
			child(tagBuilder.build());
		}
		return this;
	}

}
