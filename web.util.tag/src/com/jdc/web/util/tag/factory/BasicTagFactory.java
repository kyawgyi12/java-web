package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Tag;

public class BasicTagFactory implements AbstractTagFactory {
	
	private Tag basicTag;

	@Override
	public Tag create() {
		return basicTag;
	}
	
	public BasicTagFactory(String name, String value) {
		basicTag = new BasicTag(name, value);
	}
	
	public BasicTagFactory(String name) {
		basicTag = new BasicTag(name);
	}

}
