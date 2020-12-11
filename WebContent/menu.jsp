<!--  Hacemos referencia a las librerias de jstl -->
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Crearemos una variable con la fecha del dia -->
<jsp:useBean id="actual" class="java.util.Date" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="body">
	<table>
		<!-- Definimos unos links para cambiar el idioma -->
		<tr>
			<td class="control">
				Cambiar Idioma
				<ul>
					<li><a href="idioma.do?idioma=it">Italiano</a></li>
					<li><a href="idioma.do?idioma=de">Alemán</a></li>
					<li><a href="idioma.do?idioma=es&pais=MX">Español México</a></li>
				</ul>
			</td>
		</tr>
		
		<!-- Menu -->
		<tr>
			<td class="control">
				<a href="bienvenida.jsp"><fmt:message key="menu.bienvenida" /></a>
			</td>
		</tr>
		<tr>
			<td class="control">
				<a href="logueo.jsp"><fmt:message key="menu.logueo" /></a>
			</td>
		</tr>
		<tr>
			<td class="control">
				<a href="listadoDeUsuarios.jsp"><fmt:message key="menu.listado" />
			</a>
			</td>
		</tr>
		<tr>
			<td class="control">
				<fmt:formatDate type="date" dateStyle="long" value="${actual}" />
			</td>
		</tr>
	</table>
	<br>
</body>
</html>