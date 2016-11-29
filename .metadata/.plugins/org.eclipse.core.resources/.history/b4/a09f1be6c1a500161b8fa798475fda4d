<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

   <script src ="./js/bootstrap.min.js"></script>

   


   
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
   <nav class="navbar navbar-default" role="navigation">
  <!-- El logotipo y el icono que despliega el menú se agrupan
       para mostrarlos mejor en los dispositivos móviles -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse"
            data-target=".navbar-ex1-collapse">
      <span class="sr-only">Desplegar navegación</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Logotipo</a>
  </div>
 
  <!-- Agrupar los enlaces de navegación, los formularios y cualquier
       otro elemento que se pueda ocultar al minimizar la barra -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <form class="navbar-form navbar-left" role="search">
      <div class="form-group ">
        <input type="text" class="form-control" placeholder="Buscar producto ...">
      </div>
      <button type="submit" class="btn btn-default">Buscar</button>
    </form>
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Busqueda avanzada <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group ">
              <input type="text" class="form-control" placeholder="Categoria ...">
              <input type="text" class="form-control" placeholder="Ciudad ...">
              <input type="text" class="form-control" placeholder="Vendedor ...">
              <input type="text" class="form-control" placeholder="Titulo ...">
              <input type="text" class="form-control" placeholder="Descripción ...">
            </div>
            <button type="submit" class="btn btn-default">Buscar</button>
          </form>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li> 
        <div class="form-group ">     
          <form class="form-inline navbar-form" role="form">
              <label class="sr-only" for="ejemplo_email_2">Email</label>
              <input type="email" class="form-control" id="ejemplo_email_2"
                     placeholder="Introduce tu email">
              <label class="sr-only" for="ejemplo_password_2">Contraseña</label>
              <input type="password" class="form-control" id="ejemplo_password_2" 
                     placeholder="Contraseña">
              <button type="submit" class="btn btn-default">Entrar</button>
            </div>
          </form>
      </li>
      <li><a href="#">Registrarse</a></li>
    </ul>
  </div>
</nav>

    <div class="container">
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="row">
          <div class="list-group">
            <div class="list-group-item">
              <h4>Nombre  </h4>${sessionScope.usuario.nombre}
            </div>
            <div class="list-group-item">
              <h4>Primer apellido  </h4>${sessionScope.usuario.apellido1}
            </div>
            <div class="list-group-item">
              <h4>Segundo apellido  </h4>${sessionScope.usuario.apellido2}
            </div>
            <div class="list-group-item">
              <h4>Contraseña  </h4><a href="" >********</a>
            </div>
            <div class="list-group-item">
              <h4>E-mail  </h4>${sessionScope.usuario.email}
            </div>
            <div class="list-group-item">
              <a href="/wallapoptiw/editarUsuario.jsp" class="btn btn-default">Editar pefil</a>
              <a href="#" class="btn btn-default">Administrar productos</a>
            </div>
          </div>
          <div class="col-xs-12 col-lg-4">
              <h2>Heading</h2>
              <img src="cirujano.jpg" alt="prueba" class="img-rounded">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-12 col-lg-4">
              <h2>Heading</h2>
              <img src="cirujano.jpg" alt="prueba" class="img-rounded">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-12 col-lg-4">
              <h2>Heading</h2>
              <img src="cirujano.jpg" alt="prueba" class="img-rounded">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </p>
              <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div><!--/.col-xs-6.col-lg-4-->
        </div><!--/.row-->
      </div><!--/.offcanvas-->
    </div><!--/.container-->
    <hr>
    <footer>
      <p>&copy; 2016 Company, Inc.</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="offcanvas.js"></script>
  </body>
</html>
html>