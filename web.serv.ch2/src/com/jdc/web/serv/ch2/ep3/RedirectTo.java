package com.jdc.web.serv.ch2.ep3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectTo
 */
@WebServlet("/redirect-to")
public class RedirectTo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", "Redirect Servlet");
		getServletContext().getRequestDispatcher("/header").include(request, response);
		
		PrintWriter pw = response.getWriter();
		pw.write("<h1>This is Message From Redirect Servlet</h1>");
		pw.write("<br />");
		pw.write("<br />");
		pw.write("<a href='javascript:history.back();'>Back</a>");
		pw.write("<br />");
		pw.write("<br />");
		
		getServletContext().getRequestDispatcher("/footer").include(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
