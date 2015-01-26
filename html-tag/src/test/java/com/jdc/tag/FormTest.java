package com.jdc.tag;

import org.junit.Test;

import com.jdc.html.tag.container.Div;
import com.jdc.html.tag.form.Form;
import com.jdc.html.tag.form.Input;
import com.jdc.html.tag.form.InputType;
import com.jdc.html.tag.form.Label;
import com.jdc.html.tag.form.Method;

public class FormTest {

	@Test
	public void test() {
		Form form = Form.builder().styleClass("form form-horizontal")
				.method(Method.post).action("student-list").id("student-form");

		form.child(Div
				.builder()
				.styleClass("form-group")
				.child(Label.builder("Name")
						.styleClass("control-label col-xs-4").build(),
						Div.builder()
								.styleClass("col-xs-8")
								.child(Input.builder().type(InputType.text)
										.styleClass("form-control")
										.name("name").build()).build()

				).build());

		form.child(Div
				.builder()
				.styleClass("form-group")
				.child(Label.builder("Password")
						.styleClass("control-label col-xs-4").build(),
						Div.builder()
								.styleClass("col-xs-8")
								.child(Input.builder().type(InputType.password)
										.styleClass("form-control")
										.name("password").build()).build()

				).build());

		System.out.println(form.build().html());
	}

}
