package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.Tag;

public class TagFactory {

	public static Tag create(AbstractTagFactory factory) {
		return factory.create();
	}
}
