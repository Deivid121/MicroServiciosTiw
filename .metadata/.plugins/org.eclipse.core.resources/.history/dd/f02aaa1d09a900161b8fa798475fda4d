<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
   <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

   <script src ="./js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="menu.jsp" />


    <table class="table table-hover">
    <h2>Usuarios del sistema</h2>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido1</th>
            <th>Apellido2</th>
            <th>Email</th>
            <th>Contraseña</th>
            <th>Ciudad</th>
            <th>Opciones</th>
        </tr>
        <tr>
        <c:if test="empty usuarios"><p>Usuarios vacíos</p></c:if>
        
<c:forEach items="${usuarios}" var="usuario"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
	<form>
		<td>${usuario.id }</td> <!-- Usuario es un POJO por lo que podemos acceder a sus propiedades sin necesidad de get/set -->
		<td>${usuario.nombre }</td>
		<td>${usuario.apellido1 }</td>
		<td>${usuario.apellido2 }</td>
		<td>${usuario.email }</td>
		<td>${usuario.password }</td>
		<td>${usuario.ciudad }</td>
		
	
		<td>
		<a href="usuarioAdmin?id=${usuario.id }"><span class="glyphicon glyphicon-tag"></span></a>
		<a href="editarUsuarioAdmin?id=${usuario.id}"><span class="glyphicon glyphicon-edit"></span></a>
		<a href="borrarUsuarioAdmin?id=${usuario.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

	</form>
	</tr>
	</c:forEach>
	

	 <table class="table table-hover">
	 <h2>Productos del sistema</h2>
<tr>
<th>Id</th>
<th>Titulo</th>
<th>Categoría</th>
<th>Descripción</th>
<th>Precio</th>
<th>Imagen</th>
<th>Estado</th>
<th>Opciones</th>

</tr>


<c:forEach items="${productos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
<form>
	<td>${producto.id }</td> 
	<td>${producto.titulo }</td> 
	<td>${producto.categoria }</td>
	<td>${producto.descripcion }</td>
	<td>${producto.precio }</td>
	<td><img src = "./imagenes/${producto.imagen }" width ="25" height="25"></td>
	<td>${producto.estado }</td>



	
		
		<td>
		<a href="VerProductosAdmin?id=${producto.id }"><span class="glyphicon glyphicon-tag"></span></a>
		<a href="EditarProductoAdmin?id=${producto.id}"><span class="glyphicon glyphicon-edit"></span></a>
		<a href="eliminarProductoClave?id=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
	</form>
	</tr>
	</c:forEach>
	
</body>
</html>