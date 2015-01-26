package com.jdc.html.tag;

import com.jdc.html.tag.BaseTag.TagBuilder;

public class Html implements Tag {
	
	private Tag html;

	@Override
	public String html() {
		StringBuffer sb = new StringBuffer("<!DOCTYPE html>\n");
		sb.append(html.html());
		return sb.toString();
	}
	
	private Html(HtmlTagBuilder builder) {
		this.html = builder.html.build();
	}
	
	public static class HtmlTagBuilder {
		
		private TagBuilder html;
		private TagBuilder head;
		private TagBuilder body;
		
		private HtmlTagBuilder() {
			html = BaseTag.builder(Type.html);
			head = BaseTag.builder(Type.head);
			body = BaseTag.builder(Type.body);
			
			html.child(head.build(), body.build());
		}
		
		public HtmlTagBuilder head(Tag ... tags) {
			head.child(tags);
			return this;
		}
		
		public HtmlTagBuilder body(Tag ... tags) {
			body.child(tags);
			return this;
		}
		
		public Html build() {
			return new Html(this);
		}
	}
	
	public static HtmlTagBuilder builder() {
		return new HtmlTagBuilder();
	}

}
