<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP</title>

<link href="../resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<div class="container">
	
	<div class="jumbotron">
		<h3>First JSP</h3>
		
		<p>In this tutorial we are using scriptlet tags, Declaration, 
		Expressions and Default Object that can be used in jsp. </p>
		
		<p>
			<a href="../index.jsp" class="btn btn-success">Top Page</a>
		</p>
	</div>

	<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Declaration and Expression</h4>
	</div>
	<div class="panel-body">
		<p>
			<%=  "&lt;%! String str = \"Hello JSP\"; %&gt;" %>
			<%! String str = "Hello JSP"; %>
		</p>
		<p>
			<%= "&lt;%= str %&gt;" %>
		</p>
		<p>
			<%= str %>
		</p>
	</div>
	</div>
	<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Using Expression</h4>
	</div>
	<div class="panel-body">
		<p>
			<%= "&lt;%= String.format(\"str.equals(\"Nothing\") is %s\", str.equals(\"Nothing\")) %&gt;" %>
		</p>
		<p>
			<%= String.format("str.equals(\"Nothing\") is %s", str.equals("Nothing")) %>
		</p>
	</div>
	</div>
	<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Using Scriptlet and Default Object</h4>
	</div>
	<div class="panel-body">
		<p>
			<%= "&lt;% out.print(str); %&gt;" %>
		</p>
		<p>
			<% out.print(str); %>
		</p>
	</div>
	</div>
</div>

</body>
</html>