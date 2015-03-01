<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<h4>Add New Restaurant</h4>
</div>

	<form class="form form-horizontal" method="post" action="${ baseUrl.url('restaurant/save') }">
		<div class="row">
		<div class="col-sm-6">
		<div class="form-group">
			<label class="control-label col-sm-4">Name</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Enter Name of Restaurant" name="name" required="required"/>
			</div>
		</div>	
		<div class="form-group">
			<label class="control-label col-sm-4">Township</label>
			<div class="col-sm-8">
				<select class="form-control"  name="township_id">
					<c:forEach items="${ townships }" var="item">
						<option value="${ item.id }"><c:out value="${ item.name }" /> </option>
					</c:forEach>
				</select>
			</div>
		</div>	
		<div class="form-group">
			<label class="control-label col-sm-4">Address</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Enter Address"  name="address" required="required"/>
			</div>
		</div>
		</div>
		
		<div class="col-sm-6">
		<div class="form-group">
			<label class="control-label col-sm-4">Opening Hours</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="HH:mm - HH:mm"  name="opening"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Home Page</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Enter Homepage of Restaurant"  name="homepage"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">Email</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Enter Email"  name="email"/>
			</div>
		</div>
		</div>
		
		<div class="row">
		<div class="col-sm-12">
			<div class="form-group">
				<div class="col-sm-12">
					<label class="control-label col-sm-2">Phone</label>
					<div class="col-sm-10">
						<input  name="phone" type="text" class="form-control" placeholder="Enter Phones with comma seperated"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<label class="control-label col-sm-2">Category</label>
					<div class="col-sm-10">
					<div class="row">
						<c:forEach items="${ categories }" var="category">
						<div class="col-xs-3">
							<label class="control-label">
							<input type="checkbox" name="category" value="${ category.id }"  name="category"/>
							 <c:out value="${ category.name }"></c:out>
							</label>
						</div>
						</c:forEach>
					</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<label class="control-label col-sm-2">Description</label>
					<div class="col-sm-10">
						<textarea rows="4" cols="20" class="form-control"  name="description"></textarea>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<div class="col-sm-10 col-sm-offset-2">
						<a href="#" onclick="javascript:history.back()" class="btn btn-default">BACK</a>
						<input type="submit" class="btn btn-primary" value="SAVE" />
					</div>
				</div>
			</div>

		</div>
		</div>

	</div>		
			
	</form>
