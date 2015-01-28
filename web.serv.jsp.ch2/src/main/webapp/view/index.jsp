<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Day 2</title>

<link rel="stylesheet" href="/web.serv.jsp.ch2/resources/css/bootstrap.min.css">
</head>
<body>

<div class="container">
<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="/web.serv.jsp.ch2/students/list"><span class="glyphicon glyphicon-home"></span> JSP - Day 2</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li><a href="/web.serv.jsp.ch2/students/list">Student List</a></li>
      <li><a href="/web.serv.jsp.ch2/students/add">Add New Student</a></li>
    </ul>
  </div>
</nav>

<div class="row">
	<div class="col-xs-12">
		<div class="jumbotron">
			<h2>${title}</h2>
		</div>
	</div>

	<div class="col-xs-12">
		<jsp:include page="${page}.jsp"></jsp:include>
	</div>
</div>
</div>


<script type="text/javascript" src="/web.serv.jsp.ch2/resources/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/web.serv.jsp.ch2/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</body>
</html>