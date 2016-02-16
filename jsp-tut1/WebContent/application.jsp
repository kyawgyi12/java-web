<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Object</title>
</head>
<body>

<h1>Application</h1>

<table>
	<tr>
		<td>Method</td>
		<td>Result</td>
	</tr>
	
	<tr>
		<td>getAttribute</td>
		<td>
		<%	
		{
			Enumeration<String> names =  application.getAttributeNames();
			while(names.hasMoreElements()) {
				out.print("<p>");
				String name = names.nextElement();
				out.print(name + " : " + application.getAttribute(name));
				out.print("</p>");
			}
		}
		%>
		</td>
	</tr>
	
	<tr>
		<td>getContextPath</td>
		<td><%=application.getContextPath() %></td>
	</tr>

	<tr>
		<td>getServletContextName</td>
		<td><%=application.getServletContextName() %></td>
	</tr>
	
	<tr>
		<td>getServerInfo</td>
		<td><%=application.getServerInfo() %></td>
	</tr>
	
	<tr>
		<td>getInitParameterNames</td>
		<td>
		<%
		{
			Enumeration<String> names = application.getInitParameterNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				out.write(name + " : " + application.getInitParameter(name));
			}
		}
		%>
		</td>
	</tr>
	
</table>

</body>
</html>