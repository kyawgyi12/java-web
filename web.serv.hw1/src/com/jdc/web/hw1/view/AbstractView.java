package com.jdc.web.hw1.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.util.tag.Tag;
import com.jdc.web.util.tag.factory.BasicTagFactory;
import com.jdc.web.util.tag.factory.TagFactory;

public abstract class AbstractView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.getWriter().write("<!DOCTYPE html>");
		resp.getWriter().write("<html>");
		// header
		Tag head = TagFactory.create(new BasicTagFactory("head"));
		// meta
		Tag meta = TagFactory.create(new BasicTagFactory("meta"));
		meta.addAttribute("charset", "UTF-8");

		// link
		Tag bootstrapCss = TagFactory.create(new BasicTagFactory("link"));
		bootstrapCss.addAttribute("href", "resources/css/bootstrap.min.css");
		bootstrapCss.addAttribute("rel", "stylesheet");

		Tag commonCss = TagFactory.create(new BasicTagFactory("link"));
		commonCss.addAttribute("href", "resources/css/common.css");
		commonCss.addAttribute("rel", "stylesheet");

		head.addChilds(meta, bootstrapCss, commonCss);

		resp.getWriter().write(head.getHtml());
		// body
		resp.getWriter().write("<body>");
		// div container
		resp.getWriter().write("<div class='container'>");

		// nav bar
		HttpSession session = req.getSession(true);
		Object login = session.getAttribute("login");
		if (login != null) {
			Tag nav = getNaviBar();
			resp.getWriter().write(nav.getHtml());
		}

		Object message = req.getAttribute("message");
		if (null != message) {
			Tag div = TagFactory.create(new BasicTagFactory("div", message
					.toString()));
			div.addAttribute("class", "alert alert-warning");
		}

		writeView(req, resp);

		resp.getWriter().write("</div>");
		resp.getWriter().write("<body>");
		// footer
		resp.getWriter().write("</html>");
	}

	private Tag getNaviBar() {
		Tag nav = TagFactory.create(new BasicTagFactory("nav"));
		nav.addAttribute("class", "navbar navbar-inverse");
		nav.addAttribute("role", "navigation");

		// nav header
		Tag header = TagFactory.create(new BasicTagFactory("div"));
		header.addAttribute("class", "navbar-header");

		Tag a1 = TagFactory.create(new BasicTagFactory("a", "HOME"));
		a1.addAttribute("class", "navbar-brand");
		a1.addAttribute("href", "home");
		Tag spIcon = TagFactory.create(new BasicTagFactory("span"));
		spIcon.addAttribute("class", "glyphicon glyphicon-home");
		a1.addChilds(spIcon);

		header.addChilds(a1);

		Tag navBarColaps = TagFactory.create(new BasicTagFactory("div"));
		navBarColaps.addAttribute("class", "collapse navbar-collapse");

		// nav left
		Tag left = TagFactory.create(new BasicTagFactory("ul"));
		left.addAttribute("class", "nav navbar-nav");

		// item list
		left.addChilds(getMenuItemTag("Item List", "itemList"));

		// my cart
		left.addChilds(getMenuItemTag("My Cart", "myCart"));

		// sell history
		left.addChilds(getMenuItemTag("Sell History", "sellList"));

		// nav right
		Tag right = TagFactory.create(new BasicTagFactory("ul"));
		right.addAttribute("class", "nav navbar-nav navbar-right");

		// logout
		right.addChilds(getMenuItemTag("Log Out", "logout", "glyphicon-log-out"));

		navBarColaps.addChilds(left, right);
		nav.addChilds(header, navBarColaps);

		return nav;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected abstract void writeView(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	private Tag getMenuItemTag(String name, String href, String icon) {
		Tag li = TagFactory.create(new BasicTagFactory("li"));
		Tag a = TagFactory.create(new BasicTagFactory("a", name));
		if (null != icon) {
			Tag ic = TagFactory.create(new BasicTagFactory("span"));
			ic.addAttribute("class", "glyphicon " + icon);
			a.addChilds(ic);
		}
		a.addAttribute("href", href);
		li.addChilds(a);
		return li;
	}

	private Tag getMenuItemTag(String name, String href) {
		return getMenuItemTag(name, href, null);
	}
}
