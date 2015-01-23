package com.jdc.web.hw1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.hw1.model.UserModel;
import com.jdc.web.hw1.model.entity.User;

@WebServlet({ "/login", "/logout" })
public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doBusiness(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String path = req.getServletPath();
		if ("/login".equals(path)) {
			String name = req.getParameter("login-id");
			String pass = req.getParameter("password");

			UserModel model = (UserModel) getModel(User.class);
			User user = model
					.getAll()
					.stream()
					.filter(a -> a.getName().equals(name)
							&& a.getPass().equals(pass)).findAny().orElse(null);

			if (null == user) {
				showLoginView(req, resp);
			} else {
				HttpSession session = req.getSession(true);
				session.setAttribute("login", user);
				resp.sendRedirect("home");
			}
		} else {
			// clear session
			HttpSession session = req.getSession();
			session.invalidate();

			resp.sendRedirect("/" + getServletContext().getServletContextName());
		}

	}

}
