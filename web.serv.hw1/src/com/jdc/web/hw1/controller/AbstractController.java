package com.jdc.web.hw1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.hw1.model.Model;
import com.jdc.web.hw1.view.AbstractView;

public abstract class AbstractController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// doBusiness
		doBusiness(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected abstract void doBusiness(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	protected <T extends AbstractView> void loadView(Class<T> view,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher(view.getSimpleName());
		disp.forward(req, resp);
	}
	
	protected void showLoginView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("index.html");
		disp.forward(req, resp);
	}
	
	
	@SuppressWarnings("unchecked")
	protected <T> Model<T> getModel(Class<T> entity) {
		Object model = getServletContext().getAttribute(entity.getSimpleName());
		if (null == model) {
			String path = String.format("/WEB-INF/data/%s.txt",
					entity.getSimpleName());
			model = Model.getModel(entity, getServletContext()
					.getRealPath(path));
			getServletContext().setAttribute(entity.getSimpleName(), model);
		}
		return (Model<T>) model;
	}

}
