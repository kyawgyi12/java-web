package com.jdc.ygn.admin.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.RestaurantModel;
import com.jdc.ygn.admin.app.view.RestaurantVO;
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
		request("list", model.getAllVO());
		forward("restaurant/list");
	}
	
	public void details() {
		RestaurantVO vo = vo();
		if(vo != null) {
			request("item", vo);
			forward("restaurant/details");
		} else {
			// error page
		}
	}
	
	public void create() {
		forward("restaurant/add");
	}
	
	public void save() {
		RestaurantVO vo = vo();
		if(vo != null) {
			// edit
			request("item", vo);
			forward("restaurant/edit");
		} else {
			// add new
		}
		
		redirect(url("restaurant/details?id=" + vo.getRestaurant().getId()));
	}
	
	public void edit() {
		RestaurantVO vo = vo();
		if(vo != null) {
			request("item", vo);
			forward("restaurant/edit");
		} else {
			// error page
		}
	}
	
	private RestaurantVO vo() {
		String strId = param("id");
		if(null != strId && !strId.isEmpty()) {
			return model.findViewById(Long.parseLong(strId));
		}
		return null;
	}

}
