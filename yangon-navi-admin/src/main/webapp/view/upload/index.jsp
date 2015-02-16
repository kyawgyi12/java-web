<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-header"><h3><span class="fui-upload"></span> File Upload</h3></div>

<div class="row">
<form action="${ baseUrl.url('upload/restaurant') }" method="post" id="upload-form" enctype="multipart/form-data">
<div class="col-lg-3">
	<div class="share mrl">
		<ul>
			<li>
				<label class="radio">
        		<input id="restaurant" class="custom-radio" name="optionsRadios" id="optionsRadios1" value="option1" data-toggle="radio" type="radio" checked="checked">
        		<span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
       			Restaurant
      			</label>
       				</li>
			<li>
				<label class="radio">
         		<input id="category" class="custom-radio" name="optionsRadios" id="optionsRadios1" value="option1" data-toggle="radio" type="radio">
         		<span class="icons"><span class="icon-unchecked"></span><span class="icon-checked"></span></span>
        		 Category
       			</label>
       		</li>
		</ul>
		<span class="btn btn-primary btn-block btn-large">File Type</span>
	</div>
</div>
<div class="col-lg-9">
	<div class="form-group">
	<label class="demo-panel-title"><span class="fui-clip"></span> Select file to upload</label>
	<input type="file" class="file" name="load-file" />
	</div>
</div>
</form>
</div>
<script type="text/javascript">
<!--
	$( function() {
		$('#restaurant').click(function() {
			$('#upload-form').attr('action', '${baseUrl.url("upload/restaurant")}');
		});	
		
		$('#category').click(function() {
			$('#upload-form').attr('action', '${baseUrl.url("upload/category")}');
		});
	}
	);
//-->
</script>
