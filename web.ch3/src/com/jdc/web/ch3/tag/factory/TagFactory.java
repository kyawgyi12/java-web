package com.jdc.web.ch3.tag.factory;

import com.jdc.web.ch3.tag.Tag;

public class TagFactory {

	public static Tag create(AbstractTagFactory factory) {
		return factory.create();
	}
}
