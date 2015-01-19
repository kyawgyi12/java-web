package com.jdc.web.hw1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.hw1.view.ErrorView;

@WebServlet({"/addToCart", "/checkOut", "/myCart"})
public class CartController extends AbstractController{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doBusiness(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		if(session.isNew() || session.getAttribute("login") == null) {
			req.setAttribute("type", "login-error");
			req.setAttribute("message", "You need to login to do this operation.");
			loadView(ErrorView.class, req, resp);
		} else {
			
			if("/checkOut".equals(req.getServletPath())) {
				
				// TODO checkout operation
				
			} else if("/addToCart".equals(req.getServletPath())) {	
				
				// TODO add to cart operation
				
			} else {
				
				// TODO myCart Operation
			}
			
		}
	}

}
