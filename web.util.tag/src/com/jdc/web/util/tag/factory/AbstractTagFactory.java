package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.Tag;

public interface AbstractTagFactory {
	public Tag create();
	
	public AbstractTagFactory styleClass(String styleClass);
}
