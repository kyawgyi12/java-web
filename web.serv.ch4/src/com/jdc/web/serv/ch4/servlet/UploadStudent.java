package com.jdc.web.serv.ch4.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.jdc.web.serv.ch4.Gender;

@WebServlet("/student-upload")
@MultipartConfig
public class UploadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/webch4")
	private DataSource ds;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// insert sql
		String sql = "insert into student (name, dob, gender, mail, phone, address) values (?, ?, ?, ?, ?, ?)";

		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// get part from requested form
			Part part = request.getPart("load-file");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					part.getInputStream()));

			String line = null;

			// read objects from uploaded file
			while ((line = reader.readLine()) != null) {
				String[] strs = line.split("\t");

				// name
				stmt.setObject(1, strs[0]);
				// dob
				stmt.setObject(2, new Date(new SimpleDateFormat("yyyy-MM-dd")
						.parse(strs[1]).getTime()));
				// gender
				stmt.setObject(3, Gender.valueOf(strs[2]).ordinal());
				// mail
				stmt.setObject(4, strs[3]);
				// phone
				stmt.setObject(5, strs[4]);
				// address
				stmt.setObject(6, strs[5]);

				// adding to batch
				stmt.addBatch();
			}

			// batch update
			stmt.executeBatch();

		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("student-list").forward(request, response);
	}

}
