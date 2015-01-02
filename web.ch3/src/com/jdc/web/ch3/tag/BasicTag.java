package com.jdc.web.ch3.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class BasicTag implements Tag{

	private List<Tag> childs;
	
	private Map<String, String> attributes;
	
	private String name;
	private String value;
	
	public BasicTag(String name) {
		this.name = name;
		this.childs = new ArrayList<>();
		this.attributes = new HashMap<>();
	}
	
	public BasicTag(String name, String value) {
		super();
		this.name = name;
		this.value = value;
		this.childs = new ArrayList<>();
		this.attributes = new HashMap<>();
	}

	public String getHtml() {
		StringBuffer sb = new StringBuffer();
		// open tag
		sb.append(String.format("<%s ", name));
		
		// attributes
		if(attributes.size() == 0 && childs.size() == 0 && null == value) {
			sb.append("/>\n");
		} else {
			for(Entry<String, String> e : attributes.entrySet()) {
				sb.append(String.format("%s='%s' ", e.getKey(), e.getValue()));
			}
			
			if(childs.size() == 0 && null == value) {
				sb.append("/>\n");
			} else {
				sb.append(">\n");
				
				for(Tag t : childs) {
					sb.append(t.getHtml());
				}
				
				if(null != value)
					sb.append(value);
				
				sb.append(String.format("</%s>\n", name));
			}
		}
		
		return sb.toString();
	}
	
	public void addAttributes(Map<String, String> data) {
		attributes.putAll(data);
	}
	
	public void addAttribute(String key, String value) {
		attributes.put(key, value);
	}

	@Override
	public void addChilds(Tag... tags) {
		childs.addAll(Arrays.asList(tags));
	}
}
