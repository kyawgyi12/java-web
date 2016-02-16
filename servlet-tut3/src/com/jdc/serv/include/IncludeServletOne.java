package com.jdc.serv.include;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncludeServletOne")
public class IncludeServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("HeaderServlet").include(request, response);
		
		// dispacthre from request object
		RequestDispatcher disp = request.getRequestDispatcher("IncludeServletTwo");
		disp.include(request, response);
		response.getWriter().append("<br/>Message from Include Servlet One");
		
		request.getRequestDispatcher("FooterServlet").include(request, response);
	}

}
