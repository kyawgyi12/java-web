<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>

<link href="../resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<div class="container">

<div class="jumbotron">
	<h3>Using Action [forward.jsp]</h3>
	<p>
		In this tutorial we are using jsp actions. forward.jsp page has a form that's action is to forward1.jsp.
		In forward1.jsp page get request parameter to java bean object by using usingBean action and then 
		forward to forward2.jsp. forward2.jsp show bean informations.
	</p>
	
	<p>
		<a href="../index.jsp" class="btn btn-success">Top Page</a>
	</p>
</div>


<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Form that will be send to forward1.jsp</h4>
	</div>
	<div class="panel-body">
		<div class="col-xs-8">
		<form class="form form-horizontal" action="forward1.jsp" method="post">
			<div class="form-group">
				<label class="control-label col-xs-3">Name</label>
				<div class="col-xs-9">
					<input type="text" name="name" placeholder="Enter Name" class="form-control"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Phone</label>
				<div class="col-xs-9">
					<input type="text" name="phone" placeholder="Enter phone" class="form-control"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Email</label>
				<div class="col-xs-9">
					<input type="text" name="mail" placeholder="Enter Email" class="form-control"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Address</label>
				<div class="col-xs-9">
					<input type="text" name="address" placeholder="Enter Address" class="form-control"/>
				</div>
			</div>
	
			<div class="form-group">
			<div class="col-xs-9 col-xs-offset-3">
				<input type="submit" value="SEND" class="btn btn-default" />
			</div>
			</div>

		</form>
		</div>
	</div>
</div>
</div>
</body>
</html>