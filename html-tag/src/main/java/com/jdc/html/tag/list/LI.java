package com.jdc.html.tag.list;

import com.jdc.html.tag.Type;
import com.jdc.html.tag.BaseTag.TagBuilder;

public class LI extends TagBuilder {

	protected LI(String text) {
		super(Type.li, text);
	}

}
