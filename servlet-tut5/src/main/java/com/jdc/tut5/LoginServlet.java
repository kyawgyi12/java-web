package com.jdc.tut5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/LoginServlet"}
		, initParams={
				@WebInitParam(name = "user", value = "jdc-user", description = "Login User"), 
				@WebInitParam(name = "pass", value = "jdcpass", description = "Password")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get userid
		String userId = request.getParameter("loginId");
		// get pass
		String pass = request.getParameter("pass");

		// check
		if(null != userId && pass != null) {
			if(userId.equals(getInitParameter("user")) 
					&& pass.equals(getInitParameter("pass"))) {
				// add to session
				HttpSession session = request.getSession(true);
				session.setAttribute("user", userId);
				session.setAttribute("pass", pass);
				// go to user home
				response.sendRedirect("/servlet-tut5/user/home.jsp");
			}
		} else {
			response.sendRedirect("/servlet-tut5/error.html");
		}
		
	}

}
