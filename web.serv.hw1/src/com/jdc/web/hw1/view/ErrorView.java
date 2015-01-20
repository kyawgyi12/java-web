package com.jdc.web.hw1.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.AnchorTagFactory;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

@WebServlet("/ErrorView")
public class ErrorView extends AbstractView {

	private static final long serialVersionUID = 1L;

	@Override
	protected void writeView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// link to login page
		Object type = req.getAttribute("type");
		if (null != type && "login-error".equals(type.toString())) {
			Tag div = TagFactory.create(
					new BasicTagFactory("div").styleClass("well")).addChilds(
					TagFactory.create(new AnchorTagFactory("Login Page", "/"
							+ getServletContext().getServletContextName())
							.styleClass("btn btn-success")));

			resp.getWriter().write(div.getHtml());
		}
	}

}
