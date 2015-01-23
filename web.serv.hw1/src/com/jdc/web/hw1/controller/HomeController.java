package com.jdc.web.hw1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.hw1.model.SellItemModel;
import com.jdc.web.hw1.model.entity.SellItem;
import com.jdc.web.hw1.model.entity.User;
import com.jdc.web.hw1.view.HomeView;

@WebServlet("/home")
public class HomeController extends AbstractController{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doBusiness(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		if(session.isNew() || session.getAttribute("login") == null) {
			showLoginView(req, resp);
		} else {
			// get user purchase list
			HttpSession sess = req.getSession();
			User user = (User) sess.getAttribute("login");
			SellItemModel model = (SellItemModel) getModel(SellItem.class);
			req.setAttribute("userPurchase", model.findByUser(user));
			
			// load user home
			loadView(HomeView.class, req, resp);
		}
	}

}
