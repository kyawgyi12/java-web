<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<form action="/web.serv.jsp.ch2/students/save" method="post"
	class="form form-horizontal" id="student-form" >

	<div class="form-group">
		<label class="control-label col-xs-3">Name</label>
		<div class="col-xs-6">
			<input type="text" name="name" class="form-control"
				placeholder="Enter Name" required="required" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Phone</label>
		<div class="col-xs-6">
			<input type="text" name="phone" class="form-control"
				placeholder="Enter Phone" required="required" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Email</label>
		<div class="col-xs-6">
			<input type="text" name="mail" class="form-control"
				placeholder="Enter Email" required="required" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-xs-3">Address</label>
		<div class="col-xs-6">
			<input type="text" name="address" class="form-control"
				placeholder="Enter Address" required="required" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-xs-offset-3 col-xs-9">
			<a href="javascript:history.back();" class="btn btn-default">BACK</a>
			<input type="submit" value="SAVE" class="btn btn-default" id="save"/>
		</div>
	</div>
</form>
