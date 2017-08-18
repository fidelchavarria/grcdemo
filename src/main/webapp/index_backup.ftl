<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" charset="utf8" src="js/jquery.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/jquery.dataTables.min.css" />
<script type="text/javascript" charset="utf8"
	src="js/jquery.dataTables.min.js"></script>



<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>


<style>
#imaginary_container{
    margin-top:20%; /* Don't copy this */
}
.stylish-input-group .input-group-addon{
    background: white !important; 
}
.stylish-input-group .form-control{
	border-right:0; 
	box-shadow:0 0 0; 
	border-color:#ccc;
}
.stylish-input-group button{
    border:0;
    background:transparent;
}

</style>


</head>
<body>
	<h3>Prueba</h3>


	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div id="imaginary_container">
					<div class="input-group stylish-input-group">
						<input type="text" class="form-control" placeholder="Search">
						<span class="input-group-addon">
							<button type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<table id="example" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Column 1</th>
				<th>Column 2</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Row 1 Data 1</td>
				<td>Row 1 Data 2</td>
			</tr>
			<tr>
				<td>Row 2 Data 1</td>
				<td>Row 2 Data 2</td>
			</tr>
		</tbody>
	</table>
</body>
</html>