package com.jdc.web.ch3.tag.factory;

import com.jdc.web.ch3.tag.HtmlTag;
import com.jdc.web.ch3.tag.Tag;

public class HtmlTagFactory implements AbstractTagFactory {
	
	private HtmlTag tag;

	@Override
	public Tag create() {
		return tag;
	}
	
	public HtmlTagFactory(String title) {
		tag = new HtmlTag(title);
	}

}
