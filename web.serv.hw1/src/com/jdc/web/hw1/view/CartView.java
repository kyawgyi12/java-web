package com.jdc.web.hw1.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.hw1.controller.util.Cart;
import com.jdc.web.hw1.model.entity.Item;
import com.jdc.web.util.tag.Method;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.AnchorTagFactory;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.FormTagFactory;
import com.jdc.web.util.tag.factory.InputTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

@WebServlet("/CartView")
public class CartView extends AbstractView {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void writeView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Item> selected = (List<Item>) req.getAttribute("selectedItem");

		if (null != selected && selected.size() > 0) {
			// item to add
			// panel heading
			Tag panelHead = TagFactory.create(
					new BasicTagFactory("div").styleClass("panel-heading"))
					.addChilds(
							TagFactory.create(new BasicTagFactory("h3",
									"Item To Add")));

			// panel body
			Tag panelBody = TagFactory.create(new BasicTagFactory("div")
					.styleClass("panel-body"));

			Tag panel = TagFactory.create(new BasicTagFactory("div")
					.styleClass("panel panel-default"));
			panel.addChilds(panelHead, panelBody);

			Tag colDiv = TagFactory.create(new BasicTagFactory("div")
					.styleClass("col-xs-12"));
			panelBody.addChilds(colDiv);

			// form
			Tag form = TagFactory.create(new FormTagFactory(Method.post,
					"addToCart").styleClass("form form-horizontal"));
			colDiv.addChilds(form);

			// div form-control
			for (Item item : selected) {

				form.addChilds(TagFactory
						.create(new BasicTagFactory("div")
								.styleClass("form-group"))
						.addChilds(
								TagFactory
										.create(new BasicTagFactory("div")
												.styleClass("col-xs-2"))
										.addChilds(
												TagFactory
														.create(new InputTagFactory(
																"number",
																"count[]")
																.value("1")
																.styleClass(
																		"form-control")),
												TagFactory
														.create(new InputTagFactory(
																"hidden",
																"id[]").value(String.valueOf(item
																.getId())))),
								TagFactory.create(new BasicTagFactory("label",
										item.getName())
										.styleClass("col-xs-2 control-label")),
								TagFactory.create(new BasicTagFactory("label",
										String.valueOf(item.getPrice()))
										.styleClass("col-xs-2 control-label"))));
			}

			form.addChilds(TagFactory.create(new BasicTagFactory("div"))
					.addChilds(
							TagFactory.create(new AnchorTagFactory("BACK",
									"javascript:history.back();")
									.styleClass("btn btn-default")),
							TagFactory.create(new InputTagFactory("submit",
									"add").value("Add To Card").styleClass(
									"btn btn-default"))));

			resp.getWriter().write(panel.getHtml());
		}

		// items in cart
		Cart myCart = (Cart) req.getSession().getAttribute("myCart");
		if (null == myCart) {
			myCart = new Cart();
			req.getSession().setAttribute("myCart", myCart);
		}

	}

}
