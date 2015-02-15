<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Yangon Navi Admin</title>

<link href="${baseUrl.url('resources/css/bootstrap.min.css')}" rel="stylesheet">
<link href="${baseUrl.url('resources/css/flat-ui.min.css')}" rel="stylesheet">
<link href="${baseUrl.url('resources/css/demo.css')}" rel="stylesheet">
<link href="${baseUrl.url('resources/css/custom.css')}" rel="stylesheet">

</head>
<body data-twttr-rendered="true">
	<div class="container">
		<div class="row">
			<%@ include file="menu.jsp" %>
		</div>
		
		<c:forEach items="${views}" var="view">
			<jsp:include page="${view}"></jsp:include>		
		</c:forEach>		

	</div>

	<script type="text/javascript"
		src="${baseUrl.url('resources/js/jquery.min.js')}"></script>
	<script type="text/javascript"
		src="${baseUrl.url('resources/js/flat-ui.min.js')}"></script>
</body>
</html>