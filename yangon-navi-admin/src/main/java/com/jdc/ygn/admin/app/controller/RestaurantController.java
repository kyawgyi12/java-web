package com.jdc.ygn.admin.app.controller;

import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/restaurant", "/restaurant/*"})
public class RestaurantController extends AbstractController{

	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		forward("restaurant/list");
	}
	
	public void create() {
		forward("restaurant/add");
	}
	
	public void save() {
		forward("restaurant/details");
	}
	
	public void edit() {
		forward("restaurant/edit");
	}

}
