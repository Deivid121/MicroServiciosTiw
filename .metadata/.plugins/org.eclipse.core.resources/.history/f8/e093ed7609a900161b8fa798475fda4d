
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Off Canvas Template for Bootstrap</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="./js/bootstrap.min.js"></script>



<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<jsp:include page="menu.jsp" />
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="row">
				<form role="form" action="register" method="post" id="registration">
					<div class="form-group">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" data-validation-length="max30" placeholder="Nombre" name="Uname">
					</div>
					<div class="form-group">
						<label for="nombre">Primer apellido</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" data-validation-length="max30"
							placeholder="Primer apellido" name="FSurname">
					</div>
					<div class="form-group">
						<label for="nombre">Segundo apellido</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" data-validation-length="max30"
							placeholder="Segundo apellido" name="SSurname">
					</div>
					<div class="form-group">
						<label for="ejemplo_email_1">Email</label> <input data-validation="email" data-validation-error-msg="You did not enter a valid e-mail"
							class="form-control" data-validation="email"
							placeholder="Introduce tu email" name="Email">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Contraseña</label> <input
							type="password" class="form-control" data-validation="length" data-validation-length="min8"
							placeholder="Contraseña" name="pass_confirmation">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Verificar contraseña</label> <input
							type="password" class="form-control" data-validation="confirmation" 
							placeholder="Verificar contraseña" name="pass">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Ciudad</label> <select multiple
							class="form-control" name="City" size="5" data-validation="required" data-validation="length" data-validation-length="max1">
							<option>a coruna</option>
							<option>alava</option>
							<option>albacete</option>
							<option>alicante</option>
							<option>almeria</option>
							<option>asturias</option>
							<option>avila</option>
							<option>badajoz</option>
							<option>baleares</option>
							<option>barcelona</option>
							<option>burgos</option>
							<option>caceres</option>
							<option>cadiz</option>
							<option>cantabria</option>
							<option>castellon</option>
							<option>ceuta</option>
							<option>ciudad real</option>
							<option>cordoba</option>
							<option>cuenca</option>
							<option>girona</option>
							<option>granada</option>
							<option>guadalajara</option>
							<option>guipuzcoa</option>
							<option>huelva</option>
							<option>huesca</option>
							<option>jaen</option>
							<option>la rioja</option>
							<option>las palmas</option>
							<option>leon</option>
							<option>lleida</option>
							<option>lugo</option>
							<option>madrid</option>
							<option>malaga</option>
							<option>melilla</option>
							<option>murcia</option>
							<option>navarra</option>
							<option>ourense</option>
							<option>palencia</option>
							<option>pontevedra</option>
							<option>salamanca</option>
							<option>tenerife</option>
							<option>segovia</option>
							<option>sevilla</option>
							<option>soria</option>
							<option>tarragona</option>
							<option>teruel</option>
							<option>toledo</option>
							<option>valencia</option>
							<option>valladolid</option>
							<option>vizcaya</option>
							<option>zamora</option>
							<option>zaragoza</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default" name="Register">Enviar</button>
				</form>
				<script>
					$.validate({
						form : '#registration',	
						 modules : 'security',
						 onError : function($form) {
							 console.log($form);
						      return false;
						    }
				    });
				</script>
				</div>
			<!--/.row-->
		</div>
		<!--/.offcanvas-->
	</div>
	<!--/.container-->
	<hr>
	<footer>
		<p>&copy; 2016 Company, Inc.</p>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	
</body>
</html>
