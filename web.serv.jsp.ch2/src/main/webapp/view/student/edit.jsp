<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<form class="form form-horizontal"
	action="/web.serv.jsp.ch2/students/save" method="post">
	<input type="hidden" name="id" value="${item.id}" />
	<div class="form-group">
		<label class="control-label col-xs-3">Student ID</label>
		<div class="col-xs-6">
			<input type="text" name="name" class="form-control"
				disabled="disabled" value="${item.id}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Name</label>
		<div class="col-xs-6">
			<input type="text" name="name" class="form-control"
				value="${item.name}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Phone</label>
		<div class="col-xs-6">
			<input type="text" name="phone" class="form-control"
				value="${item.phone}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Email</label>
		<div class="col-xs-6">
			<input type="text" name="mail" class="form-control"
				value="${item.mail}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Address</label>
		<div class="col-xs-6">
			<input type="text" name="address" class="form-control"
				value="${item.address}" />
		</div>
	</div>
	<div class="form-group">
	<div class="col-xs-offset-3 col-xs-9">
		<a href="javascript:history.back();" class="btn btn-default">BACK</a>
		<input type="submit" value="SAVE" class="btn btn-default" />
	</div>
	</div>
</form>