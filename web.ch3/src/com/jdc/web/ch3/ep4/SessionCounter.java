package com.jdc.web.ch3.ep4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.ch3.tag.Tag;
import com.jdc.web.ch3.tag.factory.BasicTagFactory;
import com.jdc.web.ch3.tag.factory.HtmlTagFactory;
import com.jdc.web.ch3.tag.factory.TagFactory;

@WebServlet(name = "session-counter", urlPatterns = { "/session-counter" })
public class SessionCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// request select param
		String item = request.getParameter("item");
		
		// session clear check
		String clear = request.getParameter("clear");
		
		if("1".equals(clear)) {
			request.getSession().invalidate();
		}

		List<String> items = null;

		// get session object
		HttpSession sess = request.getSession(true);

		// get object from session attribute
		Object obj = sess.getAttribute("items");

		if (null == obj) {
			// for concurrency
			items = Collections.synchronizedList(new ArrayList<String>());
			// set object to session attribute
			sess.setAttribute("items", items);
		} else {
			items = (List<String>) obj;
		}
		
		if(null != item && !item.isEmpty())
			items.add(item);

		Tag html = TagFactory.create(new HtmlTagFactory("Using Session"));

		html.addChilds(
				TagFactory.create(new BasicTagFactory("h1",
						"Using Session Object")), 
						TagFactory.create(new BasicTagFactory("h2", "Items from Session")));

		
		if(items.size() > 0) {
			Tag ul = TagFactory.create(new BasicTagFactory("ul"));
			html.addChilds(ul);
			
			for(String s : items) {
				ul.addChilds(TagFactory.create(new BasicTagFactory("li", s)));
			}
		} else {
			html.addChilds(TagFactory.create(new BasicTagFactory("div", "There is no data in session.")));
		}

		Tag a = TagFactory.create(new BasicTagFactory("a", "BACK"));
		html.addChilds(TagFactory.create(new BasicTagFactory("br")), a);
		a.addAttribute("href", "javascript:history.back()");
		response.getWriter().println(html.getHtml());

	}

}
