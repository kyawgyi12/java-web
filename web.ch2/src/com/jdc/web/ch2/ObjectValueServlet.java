package com.jdc.web.ch2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ObjectValueServlet
 */
@WebServlet({ "/ObjectValueServlet", "/object-values" })
public class ObjectValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String[] DIVISIONS = {"Yangon", "Mandalay", "Tanintharye", "Sitgine", "Magway", "Pegu"};

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		for(int i = 0; i < DIVISIONS.length; i++) {
			request.setAttribute("Attribute " + (i + 1), DIVISIONS[i]);
		}
		
		getServletContext().getRequestDispatcher("/ObjectValueTargetServlet").forward(request, response);
	}

}
