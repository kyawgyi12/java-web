package com.jdc.web.hw1.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.hw1.controller.util.Cart;
import com.jdc.web.hw1.model.entity.Item;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

@WebServlet("/CartView")
public class CartView extends AbstractView {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void writeView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Item> selected = (List<Item>) req.getAttribute("selectedItem");
		
		if(null != selected && selected.size() > 0) {
			// item to add
			Tag panel = TagFactory.create(new BasicTagFactory("div"));
			panel.addAttribute("class", "panel panel-default");
			
			Tag panelHead = TagFactory.create(new BasicTagFactory("div"));
			panelHead.addAttribute("class", "panel-heading");
			panelHead.addChilds(TagFactory.create(new BasicTagFactory("h3", "Item To Add")));
			
			Tag panelBody = TagFactory.create(new BasicTagFactory("div"));
			panelBody.addAttribute("class", "panel-body");
			
			panel.addChilds(panelHead, panelBody);
			
			Tag colDiv = TagFactory.create(new BasicTagFactory("div"));
			colDiv.addAttribute("class", "col-xs-9");
			panelBody.addChilds(colDiv);
			
			// form
			Tag form = TagFactory.create(new BasicTagFactory("form"));
			form.addAttribute("method", "post");
			form.addAttribute("action", "addToCart");
			form.addAttribute("class", "form form-horizontal");
			colDiv.addChilds(form);
			
			// div form-control
			for(Item item : selected) {
				// div class form-group
				Tag formGroup = TagFactory.create(new BasicTagFactory("div"));
				formGroup.addAttribute("class", "form-group col-xs-9");
				
				// label
				Tag lbName = TagFactory.create(new BasicTagFactory("label", item.getName()));
				lbName.addAttribute("class", "col-xs-3");

				Tag lbPrice = TagFactory.create(new BasicTagFactory("label", String.valueOf(item.getPrice())));
				lbPrice.addAttribute("class", "col-xs-3");

				Tag divCol = TagFactory.create(new BasicTagFactory("div"));
				divCol.addAttribute("class", "col-xs-3");
				
				// input number
				Tag input = TagFactory.create(new BasicTagFactory("input"));
				input.addAttribute("class", "form-control");
				input.addAttribute("type", "number");
				input.addAttribute("name", "count[]");
				input.addAttribute("value", "1");
				divCol.addChilds(input);
				
				Tag hidden = TagFactory.create(new BasicTagFactory("input"));
				hidden.addAttribute("type", "hidden");
				hidden.addAttribute("name", "id[]");
				hidden.addAttribute("value", String.valueOf(item.getId()));
				
				formGroup.addChilds(lbName, lbPrice, divCol, hidden);
				form.addChilds(formGroup);
			}
			
			Tag btnGroup = TagFactory.create(new BasicTagFactory("div"));
			btnGroup.addAttribute("class", "col-xs-6");
			
			Tag back = TagFactory.create(new BasicTagFactory("a", "Back"));
			back.addAttribute("href", "javascript:history.back();");
			back.addAttribute("class", "btn btn-default");
			
			Tag add = TagFactory.create(new BasicTagFactory("input"));
			add.addAttribute("type", "submit");
			add.addAttribute("class", "btn btn-default");
			add.addAttribute("value", "Add To Card");
			
			btnGroup.addChilds(back, add);
			form.addChilds(btnGroup);
			
			resp.getWriter().write(panel.getHtml());
		}
		
		// items in cart
		Cart myCart = (Cart) req.getSession().getAttribute("myCart");
		if(null == myCart) {
			myCart = new Cart();
			req.getSession().setAttribute("myCart", myCart);
		}
		
		
	}

}
