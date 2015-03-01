package com.jdc.ygn.admin.app.controller;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.CategoryModel;
import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/user", "/user/*"})
public class UserController extends AbstractController {

	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		try {
			CategoryModel cm =new CategoryModel(connection());
			request("categories", cm.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		forward("user/home");
	}
	
	public void logout() {
		// session invalidate
		session().invalidate();
		
		// redirect to login page
		redirect(url("login"));
	}

}
