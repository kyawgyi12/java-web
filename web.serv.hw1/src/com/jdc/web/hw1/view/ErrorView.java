package com.jdc.web.hw1.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.web.util.tag.Tag;
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
		if(null != type && "login-error".equals(type.toString())) {
			Tag button = TagFactory.create(new BasicTagFactory("a", "Login Page"));
			button.addAttribute("class", "btn btn-success");
			button.addAttribute("href", "/" + getServletContext().getServletContextName());
			resp.getWriter().write(button.getHtml());
		}
	}

}
