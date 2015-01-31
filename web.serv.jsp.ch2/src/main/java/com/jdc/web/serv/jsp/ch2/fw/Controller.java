package com.jdc.web.serv.jsp.ch2.fw;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Resource(name = "jdbc/jsp-day2")
	private DataSource ds;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		request = req;
		response = resp;

		System.out.println(getServletContext().getContextPath());
		String path = req.getRequestURI();
		String[] paths = path.split("/");

		if (paths.length > 3) {
			String method = paths[3];

			Method[] methods = getClass().getDeclaredMethods();

			for (Method m : methods) {
				if (m.isAnnotationPresent(MappingUrl.class)) {
					MappingUrl url = m.getAnnotation(MappingUrl.class);
					if (url.url().equals(method)) {
						m.setAccessible(true);
						try {
							m.invoke(this);
						} catch (IllegalAccessException
								| IllegalArgumentException
								| InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void loadView(String view) {

		try {

			request.setAttribute("page", view);

			getServletContext().getRequestDispatcher(
					String.format("/view/index.jsp"))
					.forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void redirect(String redirectTo) {
		try {
			response.sendRedirect(String.format("%s%s", getServletContext()
					.getContextPath(), redirectTo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void addForView(String key, Object value) {
		request.setAttribute(key, value);
	}

	protected DataSource ds() {
		return ds;
	}

	protected String param(String name) {
		return request.getParameter(name);
	}

	protected <T> T getParams(Class<T> type) {

		try {
			T obj = type.newInstance();
			Field[] fs = type.getDeclaredFields();

			for (Field f : fs) {

				String str = request.getParameter(f.getName());
				if (null != str) {
					f.setAccessible(true);
					if (f.getType().equals(Integer.class)) {
						f.set(obj, Integer.valueOf(str));
					} else {
						f.set(obj, str);
					}
				}

			}

			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
