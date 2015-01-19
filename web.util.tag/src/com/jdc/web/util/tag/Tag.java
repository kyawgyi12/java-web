package com.jdc.web.util.tag;

import java.util.Map;

public interface Tag {

	public Tag addChilds(Tag ... tags);
	public Tag addAttributes(Map<String, String> data);
	public Tag addAttribute(String key, String value);
	public String getHtml();
}
