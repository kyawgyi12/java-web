package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Method;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.Target;

public class FormTagFactory implements AbstractTagFactory {
	
	private Form tag;

	@Override
	public Tag create() {
		return tag;
	}

	@Override
	public FormTagFactory styleClass(String styleClass) {
		tag.addAttribute("class", styleClass);
		return this;
	}
	
	public FormTagFactory(Method method, String action) {
		tag = new Form(method, action);
	}

	public static class Form extends BasicTag {

		public Form(Method method, String action) {
			super("form");
			addAttribute("method", method.toString());
			addAttribute("action", action);
		}
		
	}
	
	public FormTagFactory target(Target target) {
		tag.addAttribute("target", target.toString());
		return this;
	}
	
	public FormTagFactory target(String target) {
		tag.addAttribute("target", target);
		return this;
	}
	
}
