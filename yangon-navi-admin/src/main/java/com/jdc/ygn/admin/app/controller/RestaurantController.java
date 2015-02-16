package com.jdc.ygn.admin.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.RestaurantModel;
import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/restaurant", "/restaurant/*"})
public class RestaurantController extends AbstractController{

	private static final long serialVersionUID = 1L;
	private RestaurantModel model;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			model = new RestaurantModel(connection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void index() {
		request("list", model.getAll());
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
