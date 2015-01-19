package com.jdc.web.util.tag;

import java.util.Map;

public interface Tag {

	public void addChilds(Tag ... tags);
	public void addAttributes(Map<String, String> data);
	public void addAttribute(String key, String value);
	public String getHtml();
}
