package com.jdc.jmvc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public abstract class AbstractController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void forward(String... data) {
		try {
			List<String> views = new ArrayList<>();

			for (String s : data) {
				views.add(jsp(s));
			}
			request.setAttribute("views", views);
			getServletContext().getRequestDispatcher("/template/index.jsp")
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void redirect(String path) {
		try {
			response.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private String jsp(String str) {
		BaseUrl base = (BaseUrl) getServletContext().getAttribute("baseUrl");
		return base.jsp(str);
	}
	
	protected String url(String str) {
		BaseUrl base = (BaseUrl) getServletContext().getAttribute("baseUrl");
		return base.url(str);
	}

	protected HttpSession session() {
		return request.getSession(true);
	}
	
	protected Object session(String name) {
		return session().getAttribute(name);
	}

	protected void session(String name, Object data) {
		request.getSession(true).setAttribute(name, data);
	}


	protected void request(String name, Object data) {
		request.setAttribute(name, data);
	}
	
	protected Object request(String name) {
		return request.getAttribute(name);
	}

	protected void application(String name, Object object) {
		getServletContext().setAttribute(name, object);
	}
	
	protected Object application(String name) {
		return getServletContext().getAttribute(name);
	}
	
	protected String param(String name) {
		return request.getParameter(name);
	}
	
	protected String[] params(String name) {
		return request.getParameterValues(name);
	}
	
	protected Part file(String name) throws IOException, ServletException {
		return request.getPart(name);
	}
	
	public abstract void index();

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

			String url = req.getRequestURI();
			String[] paths = url.split("/");

			String method = "index";
			if (paths.length > 3) {
				method = paths[3];
			}

			for (Method m : this.getClass().getMethods()) {
				m.setAccessible(true);
				if (m.getName().equals(method)) {
					m.invoke(this);
					break;
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
