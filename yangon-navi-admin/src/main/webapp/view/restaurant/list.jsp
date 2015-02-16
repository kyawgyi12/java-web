<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">
	<h3><span class="fui-list-columned"></span> Restaurant List</h3>
</div>
<c:choose>
	<c:when test="${ empty list }">
		<div class="well palette-emerald">
			<h5>There is no data to show.</h5>
		</div>
	</c:when>

	<c:otherwise>
		<table class="table table-striped">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>ADDRESS</td>
				<td>PHONES</td>
			</tr>
			
			<c:forEach items="${ list }" var="item">

				<tr>
					<td>${ item.id }</td>
					<td>${ item.name }</td>
					<td>${ item.address }</td>
					<td></td>
				</tr>
				
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
