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
			um = new UserModel(connection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void index() {
		if(null == session("login"))
			forward("login/login");
		else
			redirect(url("user"));
	}
	
	public void login() {
		User user = um.getUser(param("loginid"), param("pass"));
		if(null == user) {
			forward("login/login");
		} else {
			session("login", user);
			redirect(url("user"));
		}
	}
	
}
