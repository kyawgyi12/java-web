package com.jdc.tag;

import org.junit.Test;

import com.jdc.html.tag.BaseTag;
import com.jdc.html.tag.Heading;
import com.jdc.html.tag.Html;
import com.jdc.html.tag.Html.HtmlTagBuilder;
import com.jdc.html.tag.Link;
import com.jdc.html.tag.Script;
import com.jdc.html.tag.Type;
import com.jdc.html.tag.container.Div;
import com.jdc.html.tag.meta.CharSet;
import com.jdc.html.tag.meta.MetaTag;

public class HtmlTagTest {

	@Test
	public void test() {
		HtmlTagBuilder htmlBuilder = Html.builder();
		
		// build head
		htmlBuilder.head(MetaTag.charset.content(CharSet.utf8), 
					BaseTag.builder(Type.title, "Hello").build(),
					Link.builder().href("resources/css/bootstrap.min.css").build());
		
		// build body
		htmlBuilder.body(Div.builder().styleClass("container").child(
					Div.builder().styleClass("panel panel-default").child(
							Div.builder().styleClass("panel-heading").child(
								Heading.h2("Sample Title")	
									),
							Div.builder().styleClass("panel-body")
							)
				)
				.build(),
				Script.builder().src("resources/js/bootstrap.min.js").build());
		
		System.out.println(htmlBuilder.build().html());
	}

}
