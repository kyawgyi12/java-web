<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List</title>
<link href="/servlet-tut2/resources/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>
<script src="/servlet-tut2/resources/js/jquery-2.2.0.min.js"></script>
<script src="/servlet-tut2/resources/js/bootstrap.min.js"></script>

<div class="container">

	<div class="jumbotron">
		<h1>Servlet JSP Tutorial</h1>
	</div>
	
	<div class="panel panel-default">
	
		<div class="panel-heading">Contact List</div>
		
		<div class="panel-body">
			
			<table class="table table-striped table-hover table-responsive">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<tr>
					<td>
					<a href="contacts/details?id=1">Aung Aung</a>
					</td>
					<td>0987665555</td>
					<td>agag@gmail.com</td>
					<td><a href="/servlet-tut2/contacts/edit?id=1" class="btn btn-default"><i class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a href="/servlet-tut2/contacts/delete?id=1" class="btn btn-default"><i class="glyphicon glyphicon-remove"></i></a></td>
				</tr>
				<tr>
					<td>
					<a href="contacts/details?id=1">Maung Maung</a>
					</td>
					<td>0987665555</td>
					<td>mgmg@gmail.com</td>
					<td><a href="/servlet-tut2/contacts/edit?id=1" class="btn btn-default"><i class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a href="/servlet-tut2/contacts/delete?id=1" class="btn btn-default"><i class="glyphicon glyphicon-remove"></i></a></td>
				</tr>
				<tr>
					<td>
					<a href="contacts/details?id=1">Thidar</a>
					</td>
					<td>0987665555</td>
					<td>thidar@gmail.com</td>
					<td><a href="/servlet-tut2/contacts/edit?id=1" class="btn btn-default"><i class="glyphicon glyphicon-pencil"></i></a></td>
					<td><a href="/servlet-tut2/contacts/delete?id=1" class="btn btn-default"><i class="glyphicon glyphicon-remove"></i></a></td>
				</tr>
			</table>
		
		</div>
	</div>
</div>
</body>
</html>