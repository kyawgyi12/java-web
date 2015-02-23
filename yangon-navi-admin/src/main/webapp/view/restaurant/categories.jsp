<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${ list }" var="vo">
	<div class="page-header">
		<h3><c:out value="${ vo.category.name }"></c:out></h3>
	</div>
	
	<c:forEach items="${ vo.restaurants }" var="res">
	<div class="col-lg-3">
		<c:out value="${ res.name }"></c:out>	
	</div>
	</c:forEach>
</c:forEach>
