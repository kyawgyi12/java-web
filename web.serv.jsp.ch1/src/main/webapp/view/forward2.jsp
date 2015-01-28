<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:useBean id="user" class="com.jdc.web.serv.jsp.ch1.User" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward2</title>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class="container">

<div class="jumbotron">
	<h3>Using Action [forward2.jsp]</h3>
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
		<h4>Data are send from forward1.jsp</h4>
	</div>
	<div class="panel-body">
		<div class="col-xs-8">
		<form class="form form-horizontal">
			<div class="form-group">
				<label class="control-label col-xs-3">Name</label>
				<div class="col-xs-9">
					<input type="text" name="name" value="${user.name}" class="form-control" disabled="disabled"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Phone</label>
				<div class="col-xs-9">
					<input type="text" name="phone" value="${user.phone}" class="form-control" disabled="disabled"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Email</label>
				<div class="col-xs-9">
					<input type="text" name="mail" value="${user.mail}" class="form-control" disabled="disabled"/>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-3">Address</label>
				<div class="col-xs-9">
					<input type="text" name="address" value="${user.address}" class="form-control" disabled="disabled"/>
				</div>
			</div>
		</form>
		</div>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>&lt;jsp:useBean&gt; Action Tags</h4>
	</div>
	<div class="panel-body">
<pre>
<%= "&lt;jsp:useBean id=\"user\" class=\"com.jdc.web.serv.jsp.ch1.User\" scope=\"request\"&gt;&lt;/jsp:useBean&gt;" %>		
</pre>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>&lt;jsp:setProperty&gt; Action Tags</h4>
	</div>
	<div class="panel-body">
<pre>
<%= "&lt;jsp:setProperty property=\"*\" name=\"user\"/&gt;" %>
</pre>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>&lt;jsp:forward&gt; Action Tags</h4>
	</div>
	<div class="panel-body">
<pre>
<%= "&lt;jsp:forward page=\"forward2.jsp\"&gt;&lt;/jsp:forward&gt;" %>
</pre>
	</div>
</div>

</div>
</body>
</html>