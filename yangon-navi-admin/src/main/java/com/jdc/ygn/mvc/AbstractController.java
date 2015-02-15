package com.jdc.ygn.mvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public abstract class AbstractController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Resource(name = "jdbc/yangon_navi")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void loadView(String... data) {
		try {
			List<String> views = new ArrayList<>();

			for (String s : data) {
				views.add(baseUrl(s));
			}
			request.setAttribute("views", views);
			getServletContext().getRequestDispatcher("/template/index.jsp")
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected String baseUrl(String str) {
		BaseUrl base = (BaseUrl) getServletContext().getAttribute("baseUrl");
		return base.jsp(str);
	}

	protected void redirect(String path) {
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void setRequestData(String name, Object data) {
		request.setAttribute(name, data);
	}

	protected void setSessionData(String name, Object data) {
		request.getSession(true).setAttribute(name, data);
	}

	protected String getParam(String name) {
		return request.getParameter(name);
	}

	protected Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	protected abstract void index();

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			this.request = req;
			this.response = resp;

			String servletPath = req.getServletPath();
			String[] paths = servletPath.split("/");

			String method = "index";
			if (paths.length > 2) {
				method = paths[2];
			}

			for (Method m : this.getClass().getMethods()) {
				m.setAccessible(true);
				if (m.getName().equals(method)) {
					m.invoke(this);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
