<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSP Tags</h1>

<%! int a = 10; %>
<%! int b = 20; %>
<%! String result = a  + "+" + b + " = " + (a + b); %>

<h4>Expressions</h4>
<%=result %>
<hr />

<%= a + b %>
<hr />

a == b : <%= a == b %>
<hr />

a &gt; b : <%= a > b %>
<hr />

a &lt; b : <%= a < b %>
<hr />

<h4>Scriptlet</h4>

<%
	out.print("Looping");

	out.print("<br />");

	for(int i=0; i<10; i++) {
		out.print("<br />");
		out.print("Loop " + i);
	}

%>
<hr/>
<a href="default-object.jsp">Default Objects</a>
</body>
</html>