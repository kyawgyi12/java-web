package com.jdc.tag;

import org.junit.Test;

import com.jdc.html.tag.meta.CharSet;
import com.jdc.html.tag.meta.MetaTag;

public class MetaTagTest {

	@Test
	public void test1() {
		System.out.println(MetaTag.charset.content(CharSet.utf8).html());
	}

	@Test
	public void test2() {
		System.out.println(MetaTag.keywords.content("Javascript Java HTML").html());
	}
}
