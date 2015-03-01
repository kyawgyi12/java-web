<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<h4>Category List</h4>
</div>

<div class="row">
<c:forEach items="${list}" var="item">
	<div class="col-xs-3">
		<c:out value="${item.name}"></c:out>
	</div>
</c:forEach>
</div>
