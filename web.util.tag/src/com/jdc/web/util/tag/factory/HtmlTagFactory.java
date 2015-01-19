package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.HtmlTag;
import com.jdc.web.util.tag.Tag;

public class HtmlTagFactory implements AbstractTagFactory {
	
	private HtmlTag tag;

	@Override
	public Tag create() {
		return tag;
	}
	
	public HtmlTagFactory(String title) {
		tag = new HtmlTag(title);
	}

	@Override
	public HtmlTagFactory styleClass(String styleClass) {
		tag.addAttribute("class", styleClass);
		return this;
	}

}
