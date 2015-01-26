<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Day 1</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2>JPS Day - 1</h2>
			
			<h4>Java Developer Class</h4>
		</div>
	
		<div class="row">

			<div class="col-xs-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>First JSP</h3>
					</div>
					
					<div class="panel-body">
						<p>
						This is tutorials about script tags, declaration, expression and using default objects.
						</p>
						<p>
							<a href="view/first.jsp" class="btn btn-default">First JSP</a>						
						</p>
					</div>
				</div>
			</div>
		
			<div class="col-xs-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Actions</h3>
					</div>
					
					<div class="panel-body">
						<p>
						In this tutorial we use action tags such as include, forward and param.
						include using action tag will execute in request time.
						</p>
						<p>
							<a href="view/forward.jsp" class="btn btn-default">Forward JSP</a>						
						</p>
					</div>
				</div>
			</div>

			<div class="col-xs-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Directives</h3>
					</div>
					
					<div class="panel-body">
						<p>
						In this tutorial we use include directive tag. Including by directive tag will 
						execute in translation time.
						</p>
						<p>
							<a href="view/include.jsp" class="btn btn-default">Include</a>						
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>