package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Tag;

public class InputTagFactory implements AbstractTagFactory {
	
	private Tag tag;

	@Override
	public Tag create() {
		return tag;
	}
	
	public InputTagFactory(String type, String name) {
		tag = new Input(type, name);
	}
	
	public static class Input extends BasicTag {

		public Input(String type, String name) {
			super("input");
			addAttribute("type", type);
			addAttribute("name", name);
		}
	}
	
	public InputTagFactory styleClass(String styleClass) {
		tag.addAttribute("class", styleClass);
		return this;
	}
	
	public InputTagFactory placeHolder(String place) {
		tag.addAttribute("placeholder", place);
		return this;
	}
	
	public InputTagFactory required() {
		tag.addAttribute("required", "required");
		return this;
	}
	
	public InputTagFactory value(String value) {
		tag.addAttribute("value", value);
		return this;
	}
	

}
