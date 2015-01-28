<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h3>Include Directive</h3>
		<p>
			There are two way to include other resources in jsp. One is include action tag and Another one is 
			include directive. 
		</p>
		<ul>
			<li>Include Action tag will include resource when the request is come</li>
			<li>Include Directive will include in translation time</li>
		</ul>
		<p><a href="../index.jsp" class="btn btn-success">Top Page</a></p>
	</div>
	
	<jsp:include page="include1.jsp"></jsp:include>
	
	<div class="panel panel-default">

	<div class="panel-heading">
		<h4>Include Directive</h4>
	</div>

	<div class="panel-body">
<pre>
	<%= "&lt;jsp:include page=\"include1.jsp\"&gt;&lt;/jsp:include&gt;" %>
</pre>
	</div>
	</div>
	
</div>
</body>
</html>