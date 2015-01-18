package com.jdc.web.serv.ch2.ep5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/SessionCounter", "/del-session"})
public class SessionCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Counter counter = (Counter) session.getAttribute("counter");
		
		if(null == counter) {
			counter = new Counter();
			session.setAttribute("counter", counter);
		}
		
		
		if(request.getServletPath().equals("/del-session") && !session.isNew()) {
			session.invalidate();
			counter = new Counter();
		} else {
			counter.countUp();
		}
		
		request.setAttribute("title", "Session Counter");
		request.getRequestDispatcher("header").include(request, response);

		PrintWriter pw = response.getWriter();
		pw.write(String.format("<h1>Session Access Count : %d</h1>", counter.getCount()));
		pw.write("<br />");
		pw.write("<br />");
		
		getServletContext().getRequestDispatcher("/footer").include(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
