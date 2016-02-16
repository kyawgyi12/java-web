package com.jdc.tut2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ 
	"/contacts/create", 
	"/contacts/save", 
	"/contacts/list", 
	"/contacts/edit", 
	"/contacts/details", 
	"/contacts/delete" 
})
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		switch (request.getServletPath()) {
		case "/contacts/create":
			this.create(request, response);
			break;
		case "/contacts/save":
			this.save(request, response);
			break;
		case "/contacts/list":
			this.list(request, response);
			break;
		case "/contacts/edit":
			this.edit(request, response);
			break;
		case "/contacts/details":
			this.details(request, response);
			break;
		case "/contacts/delete":
			this.delete(request, response);
			break;

		default:
			break;
		}
		
		System.out.println(String.format("%s : %s", "getServletContext", request.getServletContext()));
		System.out.println(String.format("%s : %s", "getServletPath", request.getServletPath()));
	}



	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get id from request
		
		// delete from db
		
		// redirect to list
		response.sendRedirect("/servlet-tut2/contacts/list");
	}



	private void details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get id from request
		
		// find contact object with id
		
		// set contact object to request scope
		
		// forward details.jsp
		request.getRequestDispatcher("/details.jsp").forward(request, response);
	}



	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get id from request
		
		// find contact object with id
		
		// set contact object to request scope
		
		// forward edit.jsp
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}



	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// search all contacts
		
		// set result list to request scope
		
		// forward to list.jsp
		request.getRequestDispatcher("/contact-list.jsp").forward(request, response);
	}



	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get parameters from request
		
		// create contact object
		
		// update db
		
		// redirect to list
		response.sendRedirect("/servlet-tut2/contacts/list");
	}



	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get parameters from request
		
		// create contact object
		
		// add to db
		
		// redirect to list
		response.sendRedirect("/servlet-tut2/contacts/list");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
