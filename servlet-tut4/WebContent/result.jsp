<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>

<h1>Counter Result</h1>

<table>
	<tr>
		<td>Request Count</td>
		<td><%= request.getAttribute("COUNTER") %> </td>
	</tr>
	<tr>
		<td>Session Count</td>
		<td><%= session.getAttribute("COUNTER") %> </td>
	</tr>
	<tr>
		<td>Application Count</td>
		<td><%= application.getAttribute("COUNTER") %> </td>
	</tr>
	<tr>
		<td>Cookie Count</td>
		<td><%= request.getAttribute("COOKIE_COUNTER") %> </td>
	</tr>
</table>

<a href="index.html">Index Page</a>
</body>
</html>