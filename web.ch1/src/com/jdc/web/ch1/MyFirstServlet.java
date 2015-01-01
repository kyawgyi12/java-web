package com.jdc.web.ch1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>");
		response.getWriter().println("My First Web");
		response.getWriter().println("</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>");
		response.getWriter().println("Hello Servlet!");
		response.getWriter().println("</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

}
