package com.jdc.ygn.admin.app.controller;

import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/restaurant", "/restaurant/*"})
public class RestaurantController extends AbstractController{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		loadView("restaurant/list");
	}
	
	public void create() {
		loadView("restaurant/add");
	}
	
	public void save() {
		loadView("restaurant/details");
	}
	
	public void edit() {
		loadView("restaurant/edit");
	}

}
