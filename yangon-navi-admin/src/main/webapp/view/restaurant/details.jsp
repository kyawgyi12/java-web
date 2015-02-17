<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col-lg-6">
		<img src="${ baseUrl.url('resources/img/restaurant-clip-art-3.png') }" alt="${ item.restaurant.name }" class="img-rounded img-responsive">	
	</div>
	<div class="col-lg-6">
		<div class="row">
			<div class="col-lg-12">
				<div class="footer-banner">
					<h3 class="footer-title">${ item.restaurant.name }</h3>
					<ul>
						<li>${ item.restaurant.address }</li>
						<li>${ item.township.name }</li>
	
						<c:if test="${ not empty item.restaurant.homepage }">
							<li><a href="${ item.restaurant.homepage }">${ item.restaurant.homepage }</a></li>
						</c:if>
	
						<c:if test="${ not empty item.restaurant.email }">
							<li>${ item.restaurant.email }</li>
						</c:if>
						
						<li>
							<c:forEach items="${ item.phones }" var="ph" varStatus="sts">
								<c:if test="${ sts.index > 0 }">
									<c:out value=", "></c:out>
								</c:if>
								<c:out value="${ ph.phone }"></c:out>
							</c:forEach>
						</li>
					</ul>
					<a href="#" class="btn btn-danger"><span class="fui-new"></span> EDIT</a>
				</div>
            </div>
		</div>
	</div>
</div>

<div class="row">
	<div class="page-header">
		<h4>Decoration Photo &nbsp;<a href="#" class="btn btn-default palette-carrot"><span class="fui-plus" ></span>&nbsp; ADD</a></h4>
	</div>
</div>

<div class="row">
	<div class="page-header">
		<h4>Menu &nbsp;<a href="#" class="btn btn-default palette-orange"><span class="fui-plus" ></span>&nbsp; ADD</a></h4>
	</div>
</div>