package com.jdc.ygn.admin.app.controller;

import javax.servlet.annotation.WebServlet;

import com.jdc.ygn.mvc.AbstractController;

@WebServlet(urlPatterns={"/user", "/user/*"})
public class UserController extends AbstractController {

	private static final long serialVersionUID = 1L;

	@Override
	public void index() {
		// load user data
		
		loadView("user/home");
	}
	
	public void logout() {
		// session invalidate
		session().invalidate();
		
		// redirect to login page
		redirect(baseUrl("login"));
	}

}
