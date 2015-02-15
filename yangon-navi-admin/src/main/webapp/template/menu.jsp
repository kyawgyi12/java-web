<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<div class="col-xs-12">
	<nav class="navbar navbar-inverse navbar-embossed" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse-01">
				<span class="sr-only">Toggle navigation</span>
			</button>
			<a class="navbar-brand" href="#"><img src='${baseUrl.url("resources/img/ygn.png")}' alt="Pocket"></a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse-01">
			<ul class="nav navbar-nav navbar-left">
				<li>
					<a href="#">Login</a>
				</li>
			</ul>
			<form class="navbar-form navbar-right" action="#" role="search">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" id="navbarInput-01"
							placeholder="Search" type="search"> <span
							class="input-group-btn">
							<button type="submit" class="btn">
								<span class="fui-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<!-- /navbar -->
</div>
</html>