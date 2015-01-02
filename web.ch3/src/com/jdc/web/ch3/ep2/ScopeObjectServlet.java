package com.jdc.web.ch3.ep2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdc.web.ch3.ep2.util.Const;
import com.jdc.web.ch3.ep2.util.Counter;
import com.jdc.web.ch3.tag.Tag;
import com.jdc.web.ch3.tag.factory.BasicTagFactory;
import com.jdc.web.ch3.tag.factory.HtmlTagFactory;
import com.jdc.web.ch3.tag.factory.TagFactory;

@WebServlet({ "/ch3.ep2.app", "/ch3.ep2.sess", "/ch3.ep2.req" })
public class ScopeObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer appCount = 0;
		Integer sessCount = 0;
		Integer reqCount = 0;
		
		// application counters
		Object appObj = getServletContext().getAttribute(Const.COUNTER.toString());
		if(null != appObj) {
			appCount = ((Counter)appObj).getCount();
		}
		
		// session counter
		HttpSession session = request.getSession();
		if(null != session) {
			Object sessObj = session.getAttribute(Const.COUNTER.toString());
			if(null != sessObj)
				sessCount = ((Counter) sessObj).getCount();
		}
		
		// request counter
		Object reqObj = request.getAttribute(Const.COUNTER.toString());
		if(null != reqObj) {
			reqCount = ((Counter)reqObj).getCount();
		}
		
		
		// html
		Tag html = TagFactory.create(new HtmlTagFactory(request.getServletPath()));
		
		// Header
		html.addChilds(TagFactory.create(new BasicTagFactory("h1", request.getServletPath())));

		Tag table = TagFactory.create(new BasicTagFactory("table"));
		table.addChilds(getTr("Count Type", "Count"));
		table.addChilds(getTr("Application", appCount.toString()));
		table.addChilds(getTr("Session", sessCount.toString()));
		table.addChilds(getTr("Request", reqCount.toString()));
		
		html.addChilds(table);
		html.addChilds(TagFactory.create(new BasicTagFactory("br")));
		
		Tag link = TagFactory.create(new BasicTagFactory("a", "BACK"));
		link.addAttribute("href", "javascript:history.back()");
		html.addChilds(link);
		
		response.getWriter().println(html.getHtml());
		
	}
	
	private Tag getTr(String key, String value) {
		Tag tr = TagFactory.create(new BasicTagFactory("tr"));
		tr.addChilds(TagFactory.create(new BasicTagFactory("td", key)));
		tr.addChilds(TagFactory.create(new BasicTagFactory("td", value)));
		return tr;
	}

}
