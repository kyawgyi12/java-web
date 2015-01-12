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
			out.write(this.getStudentTable(students));
			
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
	
	private Student getStudentFromRequest(HttpServletRequest request) {
		// TODO 
		return null;
	}

	private String getStudentTable(List<Student> students) {
		// TODO 
		return null;
	}


}
