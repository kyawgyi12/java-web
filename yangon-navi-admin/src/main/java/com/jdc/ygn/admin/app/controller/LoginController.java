package com.jdc.ygn.admin.app.controller;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.admin.app.model.UserModel;
import com.jdc.ygn.admin.app.model.entity.User;
import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/login", "/login/*"})
public class LoginController extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	private UserModel um;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			um = new UserModel(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void index() {
		loadView("login/login");
	}
	
	public void login() {
		User user = um.getUser(getParam("loginid"), getParam("pass"));
		if(null == user) {
			System.out.println("user not found");
			loadView("login/login");
		} else {
			System.out.println("user found");
			setSessionData("login", user);
			redirect(baseUrl("user"));
		}
	}
	
}
