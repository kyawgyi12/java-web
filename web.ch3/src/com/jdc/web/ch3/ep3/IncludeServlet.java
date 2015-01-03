package com.jdc.web.ch3.ep3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.ch3.tag.Tag;
import com.jdc.web.ch3.tag.factory.BasicTagFactory;
import com.jdc.web.ch3.tag.factory.TagFactory;

/**
 * Servlet implementation class IncludeServlet
 */
@WebServlet(name = "include", urlPatterns = { "/include" })
public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
			
		// include header
		request.getRequestDispatcher("view/header.html").include(request, response);
		
		Tag div = TagFactory.create(new BasicTagFactory("div", 
				"This is message from include servlet"));
		
		writer.println(div.getHtml());
		
		// include footer
		getServletContext().getRequestDispatcher("/view/footer.html").include(request, response);
	}

}
