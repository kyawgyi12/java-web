package com.jdc.web.serv.ch2.ep4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class CookiesCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie counter = null;
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies) {
			if("counter".equals(c.getName())) {
				counter = c;
			}
		}
		
		if(null == counter) {
			counter = new Cookie("counter", "0");
		}
		
		int count = Integer.parseInt(counter.getValue());
		counter.setValue(String.valueOf(++ count));

		request.setAttribute("title", "Cookies Counter");
		request.getRequestDispatcher("header").include(request, response);

		PrintWriter pw = response.getWriter();
		pw.write(String.format("<h1>Cookie Access Count : %d</h1>", count));
		pw.write("<br />");
		pw.write("<br />");
		
		getServletContext().getRequestDispatcher("/footer").include(request, response);
		
		response.addCookie(counter);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
