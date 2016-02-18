package com.jdc.tut6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request
		request.setAttribute("test", "Test Data");
		request.setAttribute("test", "New Test Data");
		request.removeAttribute("test");
		
		// session
		HttpSession sess = request.getSession(true);
		sess.setAttribute("session", "Session Test Creation");
		sess.setAttribute("session", "New Session Test Creation");
		sess.removeAttribute("session");
		sess.invalidate();
		
		// servlet context
		getServletContext().setAttribute("context", "Test Context Data");
		getServletContext().setAttribute("context", "New Test Context Data");
		getServletContext().removeAttribute("context");
		
		response.sendRedirect("index.jsp");
	}

}
