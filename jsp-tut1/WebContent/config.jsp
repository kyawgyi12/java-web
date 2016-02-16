<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>config</title>
</head>
<body>

<h1>config</h1>

<table>

	<tr>
		<td>Method</td>
		<td>Value</td>
	</tr>
	<tr>
		<td>getServletName</td>
		<td>
			<%=config.getServletName() %>
		</td>
	</tr>
	<tr>
		<td>getServletName</td>
		<td>
			<%
			
				Enumeration<String> names = config.getInitParameterNames();
			
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					out.print("<p>");
					out.print(name + " : " + config.getInitParameter(name));
					out.print("</p>");
				}
			%>
		</td>
	</tr>

</table>
</body>
</html>