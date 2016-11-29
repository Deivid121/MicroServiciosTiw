<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuarios</title>
</head>
<body>
	<form action="usuarioServlet" method="post">
		<fieldset>
			<legend>Formulario de Edición de Usuarios</legend>
			<label for="pk">Nombre:</label> 
			<input type="text" name="nombre" id="pk" value="${sessionScope.usuario.nombre}" size="3"   ><br>
			<label for="nom">Apellido1:</label> <input type="text" name="apellido1"
				id="nom" value="${sessionScope.usuario.apellido1}"><br> 
			<label for="apellidos">Apellido2:</label> <input type="text" name="apellido2"
				id="apellidos" value="${sessionScope.usuario.apellido2}"  ><br>
            <label for="usuario">Email:</label> <input type="text" name="email"
				id="usuario" value="${sessionScope.usuario.email}"  ><br>
			<label for="clave">Password:</label> <input
				type="password" name="password" id="clave" value="${sessionScope.usuario.password}">
				<label for="ejemplo_password_1">Ciudad:</label> <select multiple
							class="form-control" name="ciudad" size="5" data-validation="required" data-validation="length" data-validation-length="max1">
							<opton>a coruna</opton>
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
			<input type="hidden" value="EDITAR" name="accion">
		</fieldset>
		<input type="submit" value="Guardar cambios">

	</form>

</body>
</html>