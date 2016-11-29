<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Admin producto</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>

  <body>
	<jsp:include page="menuadmin.jsp" />
    <div class="container">
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="row">
          <div class="list-group">
            <div class="list-group-item">
              <h4>Nombre del Producto  </h4>${sessionScope.producto.titulo}
            </div>
            <div class="list-group-item">
              <h4>Categoría  </h4>${sessionScope.producto.categoria}
            </div>
            <div class="list-group-item">
              <h4>Descripción </h4>${sessionScope.producto.descripcion}
            </div>
            <div class="list-group-item">
              <h4>Estado </h4>${sessionScope.producto.estado}
            </div>
            <div class="list-group-item">
              <h4>Precio  </h4>${sessionScope.producto.precio}
            </div>
            <div class="list-group-item">
              <h4>Imagen  </h4>${sessionScope.producto.imagen}
            </div>
            <div class="list-group-item">
              <a href="/wallapoptiw/EditarProductoAdmin.jsp" class="btn btn-default">Editar Producto</a>
              <a href="#" class="btn btn-default">Cambiar estado del producto</a>
              
            </div>
          </div>
        </div><!--/.row-->
      </div><!--/.offcanvas-->
    </div><!--/.container-->
    <hr>
    <footer>
      <p>&copy; 2016 Company, Inc.</p>
    </footer>
  </body>
</html>
html>