package com.jdc.web.ch3.tag;

import com.jdc.web.ch3.tag.factory.BasicTagFactory;
import com.jdc.web.ch3.tag.factory.TagFactory;


public class HtmlTag extends BasicTag {
	
	private Tag head;
	private Tag body;
	
	public HtmlTag(String title) {
		
		super("html", null);
		
		Tag titleTag = TagFactory.create(new BasicTagFactory("title", title));
		head = TagFactory.create(new BasicTagFactory("head", null));
		head.addChilds(titleTag);
		body = TagFactory.create(new BasicTagFactory("body", null));
		
		super.addChilds(head, body);
		
	}

	@Override
	public void addChilds(Tag... tags) {
		body.addChilds(tags);
	}

}
