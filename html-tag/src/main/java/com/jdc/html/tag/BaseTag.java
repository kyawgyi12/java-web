package com.jdc.html.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BaseTag implements Tag{
	
	private Type type;
	private String text;
	private List<Tag> childs;
	private Map<String, String> attributes;
	
	public static TagBuilder builder(Type type) {
		return new TagBuilder(type);
	}
	
	public static TagBuilder builder(Type type, String text) {
		return new TagBuilder(type, text);
	}
	
	
	@Override
	public String html() {
		StringBuffer sb = new StringBuffer();
		// open tag
		sb.append(String.format("<%s", type.toString()));
		
		// attributes
		if(attributes.size() == 0 && childs.size() == 0 && null == text) {
			sb.append("/>\n");
		} else {
			for(Entry<String, String> e : attributes.entrySet()) {
				if(null == e.getValue()) {
					sb.append(String.format(" %s", e.getKey()));
				} else {
					sb.append(String.format(" %s='%s'", e.getKey(), e.getValue()));
				}
			}
			
			if(childs.size() == 0 && null == text) {
				sb.append("/>\n");
			} else {
				sb.append(">\n");
				
				for(Tag t : childs) {
					sb.append(t.html());
				}
				
				if(null != text)
					sb.append(String.format("%s%n", text));
				
				sb.append(String.format("</%s>\n", type.toString()));
			}
		}
		
		return sb.toString();
	}
	
	private BaseTag(TagBuilder builder) {
		type = builder.type;
		text = builder.text;
		childs = builder.childs;
		attributes = builder.attributes;
	}

	public static class TagBuilder {
		
		private Type type;
		private String text;
		private List<Tag> childs;
		private Map<String, String> attributes;

		protected TagBuilder(Type type) {
			this.type = type;
			childs = new ArrayList<Tag>();
			attributes = new HashMap<String, String>();
		}
		
		protected TagBuilder(Type type, String text) {
			this.type = type;
			this.text = text;
			childs = new ArrayList<Tag>();
			attributes = new HashMap<String, String>();
		}
		
		protected TagBuilder text(String text) {
			this.text = text;
			return this;
		}
		
		protected TagBuilder attr(String key, String value) {
			this.attributes.put(key, value);
			return this;
		}
		
		protected TagBuilder child(Tag ... tags) {
			if(null != tags)
				this.childs.addAll(Arrays.asList(tags));
			return this;
		}
		
		protected TagBuilder styleClass(String str) {
			return attr("class", str);
		}
		
		protected TagBuilder id(String id) {
			return attr("id", id);
		}
		
		public Tag build() {
			return new BaseTag(this);
		}
	}

}
