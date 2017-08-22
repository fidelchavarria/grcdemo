
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Buscardor de API remotas">
<meta name="author" content="Fidel Chavarría">
<link rel="icon" href="favico/favicon.ico">

<title>Grc Demo - Fidel Chavarría</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">



<script type="text/javascript" charset="utf8"
	src="libs/dataTables/js/jquery.js"></script>

<!--  
<link rel="stylesheet" type="text/css" href="libs/dataTables/css/jquery.dataTables.min.css" /> -->
<script type="text/javascript" charset="utf8"
	src="libs/dataTables/js/jquery.dataTables.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="libs/dataTables/css/dataTables.bootstrap.min.css" />
<script type="text/javascript" charset="utf8"
	src="libs/dataTables/js/dataTables.bootstrap4.min.js"></script>

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->



<style>
#custom-search-input {
	padding: 3px;
	border: solid 1px #E4E4E4;
	border-radius: 6px;
	background-color: #fff;
}

#custom-search-input input {
	border: 0;
	box-shadow: none;
}

#custom-search-input button {
	margin: 2px 0 0 0;
	background: none;
	box-shadow: none;
	border: 0;
	color: #666666;
	padding: 0 8px 0 10px;
	border-left: solid 1px #ccc;
}

#custom-search-input button:hover {
	border: 0;
	box-shadow: none;
	border-left: solid 1px #ccc;
}

#custom-search-input .glyphicon-search {
	font-size: 23px;
}

.center {
	margin: auto;
	width: 50%;
}

.show {
	display: inline;
}

.hide {
	display: none;
}
</style>

<script>
	$(document).ready(function() {
		
		 $(this).closest('form').find("input[type=text], textarea").val("");
		 
		$('#example').DataTable( {
	        "order": [[ 0, "desc" ]]
	    } );
		
	});
	
	function deletes(value){
		console.log('deletes: [' + value + ']');
		 $('#delete').val(value);
		 $('#frm').attr('action', "/").attr('method','post').submit();
		 return false;
	}
	
	function reload(value){
		console.log('query: [' + value + ']');
		 $('#query').val(value);
		 $('#frm').submit();
		 return false;
	}
	
</script>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Grc Demo - by Fidel Chavarría</a>
			</div>
			<!-- <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
		
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Buscardor de API remotas</h1>
			<h1>
				<a href="https://jsonplaceholder.typicode.com/" target="_blank">JSONPlaceholder</a>
			</h1>
			<p class="lead">
				Use este buscador para encontrar cadenas en todos los posibles
				títulos en la api <a
					href="https://jsonplaceholder.typicode.com/posts" target="_blank">https://jsonplaceholder.typicode.com/posts</a>
				<br> junto con el usuario que lo realizó en <a
					href="https://jsonplaceholder.typicode.com/users" target="_blank">https://jsonplaceholder.typicode.com/users</a>
				<br>
			</p>
		</div>


		<div class="container">
			<form id="frm" action="/search" method="post">
				<div class="row">
					<div class="center">
						<!-- <h2>Custom search field</h2> -->
						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" id="query" name="query" class="form-control input-lg" placeholder="Buscar" /> 
								<input type="hidden" id="delete" name="delete"/>
									<span class="input-group-btn">
									<button class="btn btn-info btn-lg" type="button">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>
							</div>
						</div>
						<label class="lead" style="margin-top:5%; width:100%"> Palabras sugeridas: provident, exercitationem, quibusdam</label>
					</div>
				</div>
			</form>
		</div>



		<div id="table-container" style="margin-top: 10%; margin-botton:20%;">
			<table id="example" class="table table-striped table-bordered"
				cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>ID</th>
						<th>Consulta</th>
						<th>Titulo</th>
						<th>Autor</th>
						<th>Email</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<#list (querySearch)! as s>
					<tr>
						<td>${s.uuid}</td>
						<td>${s.query}</td>
						<td>${s.post.title}</td>
						<td>${s.post.user.name}</td>
						<td>${s.post.user.email}</td>
						<td>
							<table>
								<tr>
									<td><a id="reload" href="javascript:reload('${s.query}');" >ejecutar</a>|</td>
									<td><a id="delete"  href="javascript:deletes('${s.id}');"  >eliminar</a></td>
								</tr>
							</table>
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>





	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->

	<script src="dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
	
</body>
</html>
