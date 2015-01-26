package com.jdc.tag;

import org.junit.Test;

import com.jdc.html.tag.A;
import com.jdc.html.tag.form.Target;

public class ATest {

	@Test
	public void test1() {
		System.out.println(A.builder("Sample", "sample.html").build().html());
	}
	
	@Test
	public void test2() {
		System.out.println(A.builder("Sample", "sample.html").target(Target._blank).build().html());
	}

	@Test
	public void test3() {
		System.out.println(A.builder("Sample", "sample.html").target("sampleTarget").build().html());
	}
}
