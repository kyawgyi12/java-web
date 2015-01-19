package com.jdc.web.hw1.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.hw1.model.entity.Item;
import com.jdc.web.util.tag.Method;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.FormTagFactory;
import com.jdc.web.util.tag.factory.InputTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

@WebServlet("/ItemListView")
public class ItemListView extends AbstractView {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void writeView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Item> list = (List<Item>) req.getAttribute("list");

		if (list.size() > 0) {
			// panel
			Tag panel = TagFactory.create(new BasicTagFactory("div"));
			panel.addAttribute("class", "panel panel-default");

			Tag panelHead = TagFactory.create(new BasicTagFactory("div",
					"Item List"));
			panelHead.addAttribute("class", "panel-heading");

			Tag panelBody = TagFactory.create(new BasicTagFactory("div"));
			panelBody.addAttribute("class", "panel-body");

			panel.addChilds(panelHead, panelBody);

			Tag colDiv = TagFactory.create(new BasicTagFactory("div"));
			colDiv.addAttribute("class", "col-xs-6");
			panelBody.addChilds(colDiv);

			Tag form = TagFactory.create(new FormTagFactory(Method.post, "item"));
			colDiv.addChilds(form);

			Tag table = TagFactory.create(new BasicTagFactory("table"));
			table.addAttribute("class", "table table-striped");

			form.addChilds(table, TagFactory.create(new InputTagFactory(
					"submit", null).value("Add To Cart").styleClass(
					"btn btn-default")));


			Tag td1 = TagFactory.create(new BasicTagFactory("td"));
			td1.addChilds(TagFactory
					.create(new InputTagFactory("checkbox", null)));

			Tag td2 = TagFactory.create(new BasicTagFactory("td", "Item"));
			Tag td3 = TagFactory.create(new BasicTagFactory("td", "Price"));

			Tag tr = TagFactory.create(new BasicTagFactory("tr"));
			tr.addChilds(td1, td2, td3);

			table.addChilds(tr);

			for (Item item : list) {
				Tag tr_1 = TagFactory.create(new BasicTagFactory("tr"));
				Tag td1_1 = TagFactory.create(new BasicTagFactory("td"));

				Tag check_1 = TagFactory.create(new InputTagFactory("checkbox",
						"item[]").value(String.valueOf(item.getId())));
				td1_1.addChilds(check_1);

				Tag td2_1 = TagFactory.create(new BasicTagFactory("td", item
						.getName()));
				Tag td3_1 = TagFactory.create(new BasicTagFactory("td", String
						.valueOf(item.getPrice())));
				tr_1.addChilds(td1_1, td2_1, td3_1);

				table.addChilds(tr_1);
			}

			resp.getWriter().write(panel.getHtml());
		}

	}

}
