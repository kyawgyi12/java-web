package com.jdc.web.hw1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.hw1.model.ItemModel;
import com.jdc.web.hw1.model.entity.Item;
import com.jdc.web.hw1.view.CartView;
import com.jdc.web.hw1.view.ItemListView;

@WebServlet({"/itemList", "/item"})
public class ItemController extends AbstractController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doBusiness(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		if(session.isNew() || session.getAttribute("login") == null) {
			showLoginView(req, resp);
		} else {
			
			if("/itemList".equals(req.getServletPath())) {
				List<Item> list = getModel(Item.class).getAll();
				if(list.size() == 0) {
					req.setAttribute("message", "There is no Item in list.");
				}
				req.setAttribute("list", list);
				loadView(ItemListView.class, req, resp);
			} else {
				String [] itemIds = req.getParameterValues("item[]");
				List<Item> items = new ArrayList<Item>();
				ItemModel model = (ItemModel) getModel(Item.class);
				for(String id : itemIds) {
					items.add(model.findById(Integer.parseInt(id)));
				}
				req.setAttribute("selectedItem", items);
				loadView(CartView.class, req, resp);
			}
		}

	}

}
