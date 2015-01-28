<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<table class="table table-striped">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Phone</th>
		<th>Mail</th>
		<th>Address</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
			<td><a href="/web.serv.jsp.ch2/students/details?id=${item.id}"><span>${item.id}</span></a></td>
			<td><span>${item.name}</span></td>
			<td><span>${item.phone}</span></td>
			<td><span>${item.mail}</span></td>
			<td><span>${item.address}</span></td>
			<td><a href="/web.serv.jsp.ch2/students/edit?id=${item.id}" title="Edit"><span class="glyphicon glyphicon-cog"></span></a></td>
			<td><a href="/web.serv.jsp.ch2/students/delete?id=${item.id}" title="Delete"><span class="glyphicon glyphicon-remove"></span></a></td>
		</tr>
	</c:forEach>
</table>



