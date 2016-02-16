package com.jdc.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String[]> dataList;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dataList = new ArrayList<>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// name
		String name = request.getParameter("name");
		// phone
		String phone = request.getParameter("phone");
		// email
		String email = request.getParameter("email");
		// address
		String address = request.getParameter("address");
		
		// add data to list
		String [] array = new String[]{name, phone, email, address};
		dataList.add(array);
		
		// showList
		this.showList(response);
	}
	
	private void showList(HttpServletResponse resp) throws IOException {
		PrintWriter w = resp.getWriter();
		w.append("<html>");
		w.append("<head>");
		w.append("<title>Customer List</title>");
		w.append("</head>");
		w.append("<body>");
		w.append("<h1>Customer List</h1>");
		w.append("<table>");
		w.append("<tr>");
		w.append("<td>Name</td>");
		w.append("<td>Phone</td>");
		w.append("<td>Email</td>");
		w.append("<td>Address</td>");
		w.append("<tr>");
		
		for(String[] array : dataList) {
			w.append("<tr>");
			w.append("<td>").append(array[0]).append("</td>");
			w.append("<td>").append(array[1]).append("</td>");
			w.append("<td>").append(array[2]).append("</td>");
			w.append("<td>").append(array[3]).append("</td>");
			w.append("<tr>");
		}
		w.append("</table>");
		w.append("</body>");
		w.append("<a href='index.html'>Customer Registration</a>");
		w.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
