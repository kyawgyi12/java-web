package com.jdc.web.serv.ch2.ep1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncludeServlet")
public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Include Servlet");

		request.getRequestDispatcher("header").include(request, response);

		PrintWriter pw = response.getWriter();
		pw.write("<h1>Message From Include Servlet</h1><br/><br/>");
		pw.write("<a href='javascript:history.back();'>Back</a>");
		pw.write("<br/><br/>");

		getServletContext().getNamedDispatcher("FooterServlet").include(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
