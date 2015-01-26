package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;

public class Script extends TagBuilder {
	
	public static Script builder() {
		return new Script();
	}

	private Script() {
		super(Type.script);
		attr("type", "text/javascript");
	}
	
	public Script src(String src) {
		attr("src", src);
		return this;
	}

}
