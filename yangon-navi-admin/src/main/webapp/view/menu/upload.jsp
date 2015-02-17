<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="create-menu-model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
  	<form action="${ addMenu }" method="post" class="form-horizontal" enctype="multipart/form-data">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Add New Menu</h4>
      </div>

      <div class="modal-body">
      <div class="row">
      <div class="col-lg-10 col-lg-offset-1">
		<div class="form-group">
			<label class="control-label">Menu Name</label>
			<input type="text" class="form-control" name="name" placeholder="Enter Menu Name" required="required"/>
		</div>
      </div>

      <div class="col-lg-10 col-lg-offset-1">
		<div class="form-group">
			<label class="control-label">Price</label>
			<input type="number" class="form-control" name="price" placeholder="Enter Price" required="required" min="0"/>
		</div>
      </div>

      <div class="col-lg-10 col-lg-offset-1">
		<div class="form-group">
			<label class="control-label">Photo</label>
			<input type="file" class="file" name="photo" required="required" />
		</div>
      </div>

      </div>

      </div>

    </div><!-- /.modal-content -->
  	</form>
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->