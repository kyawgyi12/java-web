<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Form</title>
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
		<div class="panel-heading">Contact Details</div>
		
		<div class="panel-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2">Name</label>
					<div class="col-sm-8">
						<input type="text" disabled="disabled" class="form-control" placeholder="Enter Contact Name" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2">Phone</label>
					<div class="col-sm-8">
						<input type="text" disabled="disabled" class="form-control" placeholder="Enter Contact Phone" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2">Email</label>
					<div class="col-sm-8">
						<input type="text" disabled="disabled" class="form-control" placeholder="Enter Contact Email" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2">Address</label>
					<div class="col-sm-8">
						<textarea disabled="disabled" rows="3" cols="20" class="form-control"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<a href="contacts/list" class="btn btn-primary">Contact List</a>
						<a href="contacts/edit?id=1" class="btn btn-success">Edit</a>
					</div>
				</div>

			</form>
		</div>
	</div>
</div>
</body>
</html>