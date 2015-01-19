package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.Target;

public class AnchorTagFactory implements AbstractTagFactory {
	
	private Anchor tag;


	public AnchorTagFactory(String value, String href) {
		
		tag = new Anchor("a", value);
		tag.addAttribute("href", href);
	}
	
	@Override
	public Tag create() {
		return tag;
	}
	
	public AnchorTagFactory addIcon(String icon) {
		Tag ic = TagFactory.create(new BasicTagFactory("span"));
		ic.addAttribute("class", "glyphicon " + icon);
		tag.addChilds(ic);
		return this;
	}
	
	public static class Anchor extends BasicTag {

		private Anchor(String name, String value) {
			super(name, value);
		}

	}
	
	public AnchorTagFactory target(Target target) {
		tag.addAttribute("target", target.toString());
		return this;
	}
	
	public AnchorTagFactory target(String target) {
		tag.addAttribute("target", target);
		return this;
	}

	@Override
	public AnchorTagFactory styleClass(String styleClass) {
		tag.addAttribute("class", styleClass);
		return this;
	}

}
