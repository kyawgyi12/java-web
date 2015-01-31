package com.jdc.web.serv.ch4.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jdc.web.serv.ch4.Gender;
import com.jdc.web.serv.ch4.Student;
import com.jdc.web.serv.ch4.util.SqlHelper;

@WebServlet(urlPatterns = "/student-add", loadOnStartup = 1)
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/webch4")
	private DataSource ds;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// add to table
		
		try (Connection conn = ds.getConnection()){
			Student student = getStudentFromRequest(request);

			String sql = "insert into student (name, dob, gender, mail, phone, address) values (?, ?, ?, ?, ?, ?)";
			SqlHelper<Student> helper = new SqlHelper<Student>(Student.class);

			PreparedStatement stmt = conn.prepareStatement(sql);
			Map<String, Object> param = helper.getMap(student);
			
			stmt.setObject(1, param.get("name"));
			stmt.setObject(2, param.get("dob"));
			stmt.setObject(3, param.get("gender"));
			stmt.setObject(4, param.get("mail"));
			stmt.setObject(5, param.get("phone"));
			stmt.setObject(6, param.get("address"));
			
			stmt.executeUpdate();

		} catch (ParseException | SQLException | InstantiationException
				| IllegalAccessException e) {
			
			e.printStackTrace();
		} 

		// forward to list
		// request.getRequestDispatcher("student-list").forward(request, response);
		
		response.sendRedirect(String.format("%s/%s", getServletContext().getContextPath(), "student-list"));

	}

	private Student getStudentFromRequest(HttpServletRequest request)
			throws ParseException {
		// get param from request
		Student student = new Student();
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		student.setName(name);
		student.setGender(Gender.values()[Integer.parseInt(gender)]);
		student.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(dob));

		student.setMail(mail);
		student.setPhone(phone);
		student.setAddress(address);

		return student;
	}

}
