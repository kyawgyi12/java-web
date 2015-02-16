<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-lg-12">
		<div class="page-header">
			<h4>Categories</h4>
		</div>
		<c:forEach items="${ categories }" var="item">
			<div class="col-lg-3">
				${ item.name }
			</div>
		</c:forEach>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
	<div class="page-header">
		<h4>Townships</h4>
	</div>
	<c:forEach items="${ townships }" var="item">
		<div class="col-lg-3">
			${ item.name }
		</div>
	</c:forEach>
	</div>
</div>
