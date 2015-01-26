package com.jdc.html.tag.meta;

import com.jdc.html.tag.Tag;

public enum MetaTag implements Tag {

	charset("charset") {
		@Override
		public String html() {
			return String
					.format("<meta %s=\"%s\">%n", name, content);
		}
		
		@Override
		@Deprecated
		public Tag content(String content) {
			return super.content(content);
		}
	}, 
	author("author") {
		@Override
		@Deprecated
		public MetaTag content(CharSet carset) {
			return super.content(carset);
		}
	}, 
	description("description") {
		@Override
		@Deprecated
		public MetaTag content(CharSet carset) {
			return super.content(carset);
		}
	},
	generator("generator") {
		@Override
		@Deprecated
		public MetaTag content(CharSet carset) {
			return super.content(carset);
		}
	},
	application("application-name") {
		@Override
		@Deprecated
		public MetaTag content(CharSet carset) {
			return super.content(carset);
		}
	},
	keywords("keywords") {
		@Override
		@Deprecated
		public MetaTag content(CharSet carset) {
			return super.content(carset);
		}
	};

	protected String name;
	protected String content;
	
	private MetaTag(String name) {
		this.name = name;
	}
	
	public Tag content(String content) {
		this.content = content;
		return this;
	}
	
	public MetaTag content(CharSet carset) {
		content(charset.toString());
		return this;
	}

	@Override
	public String html() {
		return String
				.format("<meta name=\"%s\" content=\"%s\">\n", name, content);
	}

}
