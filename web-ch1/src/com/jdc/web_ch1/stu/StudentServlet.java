package com.jdc.web_ch1.stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/student-list", "/student-new", "/student-add" }, name = "StudentServlet", loadOnStartup = 1)
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doBusiness(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doBusiness(request, response);
	}

	private void doBusiness(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext().log("call doBusiness");
		
		String path = request.getServletPath().trim();
		
		// get list from app scope
		List<Student> students = this.getStudents();

		if ("/student-list".equals(path)) {
			// generate html by using list
			PrintWriter out = response.getWriter();
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<div class='container'>");
			out.write("<title>Student List</title>");
			out.write("<link href='resources/css/bootstrap.min.css' rel='stylesheet'>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1>Student List</h1>");
			out.write("<br/><br/>");
			out.write(this.getStudentTable(students));
			out.write("<a href='/web-ch1/' class='btn btn-default'>Back</a>");
			out.write("</div>");
			out.write("<script type='text/javascript' src='resources/js/bootstrap.min.js'></script>");
			out.write("<script type='text/javascript' src='resources/js/jquery.easing.min.js'></script>");
			out.write("</body>");
			out.write("</html>");
			
		} else if ("/student-new".equals(path)) {
			// forward new-student.html
			getServletContext().getRequestDispatcher("/page/new-student.html")
					.forward(request, response);
		} else if ("/student-add".equals(path)) {
			// add student to list
			this.getStudents().add(this.getStudentFromRequest(request));
			// forward to student-list
			getServletContext().getRequestDispatcher("/student-list").forward(request, response);
		} 
	}

	private List<Student> getStudents() {
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) getServletContext().getAttribute("students");
		if(null == students) {
			students = new ArrayList<>();
			getServletContext().setAttribute("students", students);
		}
		return students;
	}
	
	private Student getStudentFromRequest(HttpServletRequest r) {
		Student s = new Student();
		s.setName(r.getParameter("name"));
		s.setPhone(r.getParameter("phone"));
		s.setMail(r.getParameter("mail"));
		s.setAddress(r.getParameter("address"));
		s.setTownship(r.getParameter("township"));
		s.setGender(Boolean.parseBoolean(r.getParameter("gender")));
		return s;
	}

	private String getStudentTable(List<Student> students) {
		StringBuffer sb = new StringBuffer();
		if(null != students && students.size() > 0) {
			sb.append("<table class='table table-striped'>");
			
			sb.append("<tr>");
			sb.append("<td>Name</td>");
			sb.append("<td>Gender</td>");
			sb.append("<td>Phone</td>");
			sb.append("<td>Email</td>");
			sb.append("</tr>");
			
			for (Student s : students) {
				sb.append("<tr>");
				sb.append("<td>"+ s.getName() +"</td>");
				sb.append("<td>"+ ((s.isGender())?"Male":"Female") +"</td>");
				sb.append("<td>"+ s.getPhone() +"</td>");
				sb.append("<td>"+ s.getMail() +"</td>");
				sb.append("</tr>");
			}
			
			sb.append("</table>");
		}
		return sb.toString();
	}


}
