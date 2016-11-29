<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error{color:red;font-weight: bold;}
</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<c:if test="${empty listaProductos }"> <!-- usuarios es un atributo metido en el request por eso no es necesario ponerle el prefijo param -->
<p class="error">Si no ves productos es porque has accedido directamente a la pagina y por tanto no has pasado
por el servlet controlador y no hay datos en el objeto request.
</p>
</c:if>
<table border="1">
<tr>
<th>Titulo</th>
<th>Categoría</th>
<th>Descripción</th>
<th>Precio</th>
<th>Imagen1</th>
<th>Imagen</th>
</tr>
<c:forEach items="${listaProductos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
	<td>${producto.titulo }</td> 
	<td>${producto.categoria }</td>
	<td>${producto.descripcion }</td>
	<td>${producto.precio }</td>
	<td>${producto.imagen }</td>
	<td><img src = "./imagenes/${producto.imagen }" width ="25" height="25"></td>
</tr>

</c:forEach>
</table>
</body>
</html>