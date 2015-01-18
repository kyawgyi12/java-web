package com.jdc.web.serv.ch2.ep2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Forward", urlPatterns="/forward-to")
public class ForwardTo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/header").include(request, response);
		
		PrintWriter pw = response.getWriter();
		pw.write("<h1>This is Message From Forward To Servlet</h1>");
		pw.write("<br />");
		pw.write("<br />");
		
		getServletContext().getRequestDispatcher("/footer").include(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
