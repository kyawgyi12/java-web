package com.jdc.web.serv.ch4.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jdc.web.serv.ch4.Student;
import com.jdc.web.serv.ch4.util.SqlHelper;
import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.TableTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

@WebServlet(urlPatterns="/student-list", loadOnStartup=1)
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/webch4")
	private DataSource ds;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			List<Student> list = new SqlHelper<>(Student.class)
					.getFromResultSet(rs);

			Tag container = getContents(list);

			// header
			StringBuffer header = (StringBuffer) request.getAttribute("header");
			response.getWriter().write(header.toString());
			
			// body
			response.getWriter().write(container.getHtml());
			
			// footer
			StringBuffer footer = (StringBuffer) request.getAttribute("footer");
			response.getWriter().write(footer.toString());

		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private Tag getContents(List<Student> list) {
		// container
		return TagFactory
				.create(new BasicTagFactory("div").styleClass("container"))
				.addChilds(
				// jumbotron
						TagFactory.create(
								new BasicTagFactory("div")
										.styleClass("jumbotron")).addChilds(
								TagFactory.create(new BasicTagFactory("h2",
										"Student List"))),
						// panel
						TagFactory
								.create(new BasicTagFactory("div")
										.styleClass("panel panel-default"))
								.addChilds(
								// panel-heading
										TagFactory.create(new BasicTagFactory(
												"div")
												.styleClass("panel-heading")).addChilds(TagFactory.create(new BasicTagFactory("h4", "Student Table"))),
										// panel-body
										TagFactory
												.create(new BasicTagFactory(
														"div")
														.styleClass("panel-body"))
												.addChilds(
														TagFactory
																.create(new TableTagFactory()
																		.addAllData(
																				list,
																				Student.class).styleClass("table table-striped")))));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
