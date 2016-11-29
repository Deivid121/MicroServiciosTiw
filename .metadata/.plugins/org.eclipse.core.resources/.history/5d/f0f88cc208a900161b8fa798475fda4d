<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<title>Editar Usuarios</title>
</head>
<body>
<jsp:include page="menu.jsp" />
<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="row">
				<form role="form" action="usuarioServlet" method="post" id="edituser">
					<div class="form-group">
						<label>Nombre</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" 
							data-validation-length="max30" placeholder="Nombre" name="nombre" value="${sessionScope.usuario.nombre}">
					</div>
					<div class="form-group">
						<label>Primer apellido</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length"
							 data-validation-length="max30"	placeholder="Primer apellido" name="apellido1" value="${sessionScope.usuario.apellido1}">
					</div>
					<div class="form-group">
						<label for="nombre">Segundo apellido</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" data-validation-length="max30"
							placeholder="Segundo apellido" name="apellido2" value="${sessionScope.usuario.apellido2}">
					</div>
					<div class="form-group">
						<label for="ejemplo_email_1">Email</label> <input data-validation="email" 
						data-validation-error-msg="Debes introducir un email valido"
							class="form-control" data-validation="email"
							placeholder="Introduce tu email" name="email" value="${sessionScope.usuario.email}">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Contraseña</label> <input
							type="password" class="form-control" data-validation="length" data-validation-length="min8"
							placeholder="Contraseña" name="clave_confirmation" value="${sessionScope.usuario.password}">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Verificar contraseña</label> <input
							type="password" class="form-control" data-validation="confirmation" 
							placeholder="Verificar contraseña" name="clave">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Ciudad</label> <select multiple
							class="form-control" name="ciudad" size="5" data-validation="required" data-validation="length" data-validation-length="max1">
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
						form : '#edituser',	
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
</body>
</html>