<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default" role="navigation">
	<!-- El logotipo y el icono que despliega el men煤 se agrupan
       para mostrarlos mejor en los dispositivos m贸viles -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Desplegar navegaci贸n</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">Logotipo</a>
	</div>

	<!-- Agrupar los enlaces de navegaci贸n, los formularios y cualquier
       otro elemento que se pueda ocultar al minimizar la barra -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group ">
				<input type="text" class="form-control"
					placeholder="Buscar producto ...">
			</div>
			<button type="submit" class="btn btn-default">Buscar</button>
		</form>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Busqueda avanzada <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group ">
							<input type="text" class="form-control"
								placeholder="Categoria ..."> <input type="text"
								class="form-control" placeholder="Ciudad ..."> <input
								type="text" class="form-control" placeholder="Vendedor ...">
							<input type="text" class="form-control" placeholder="Titulo ...">
							<input type="text" class="form-control"
								placeholder="Descripci贸n ...">
						</div>
						<button type="submit" class="btn btn-default">Buscar</button>
					</form>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><c:choose>
					<c:when test="${logeado}">
						<div class="dropdown">
						<li class="dropdown">
						    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
						      Hola ${sessionScope.usuario.nombre} <span class="caret"></span>
						    </a>
							<ul class="dropdown-menu" role="menu">
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#">Perfil de usuario</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#">Mis productos</a></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="#">Subir producto</a></li>
								<li role="presentation" class="divider"></li>
								<li role="presentation"><a role="menuitem" tabindex="-1"
									href="logout">Desconexi髇</a></li>
							</ul>
							
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group ">
							<form class="form-inline navbar-form" role="form" action="login"
								method="post" id="login">
								<label class="sr-only" for="ejemplo_email_2">Email</label> <input
									type="text" class="form-control" name="User"
									placeholder="Introduce tu email" data-validation="email"
									data-validation-error-msg="No has introducido un email valido (a@b.c)">
								<label class="sr-only" for="ejemplo_password_2">Contrase帽a</label>
								<input type="password" class="form-control" name="Pass"
									placeholder="Contrase馻" data-validation="length"
									data-validation-length="min8"
									data-validation-error-msg="La contrase馻 tiene al menos 8 caracteres">
								<input type="submit" class="btn btn-default" value="Entrar"></input>
								<a href="registro.jsp" class="btn btn-default active" role="button">Registrarse</a>
							</form>
							
						</div>
					</c:otherwise>
				</c:choose> <script>
					$.validate({
						form : '#login',
						onError : function($form) {
							return false;
						}
					});
				</script></li>
		</ul>
	</div>
</nav>
