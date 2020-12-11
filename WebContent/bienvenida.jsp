<!--  Hacemos referencia a las librerias de jstl -->
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
			<!-- Aqui va la cabecera -->
			<td colspan="2" align="center"><jsp:include page="cabecera.jsp" />
			</td>
		</tr>
		<tr>
			<!-- Aquí va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!-- Aquí va el cuerpo -->
			<td class="control">
				<fmt:message key="bienvenida.saludo" /><br>
				RECUPERAMOS LOS DATOS USANDO EL (Expression Language) <hr><br><br>
				
				Parámetros del request (solo el usuario y la clave):<br>
				Usuario: ${param.usuario} <br>
				Clave:  ${param.clave} <br><br><hr>
				
				Sus datos recuperados del request (Atributos que han sido cargados en el request):<br>
				Nombre: ${requestScope.b_usuario1.nombre} <br>
				Direccion: ${requestScope.b_usuario1.direccion} <br>
				Distrito: ${requestScope.b_usuario1.distrito} <br>
				Telefono: ${requestScope.b_usuario1.telefono} <br>
				Fecha N: ${requestScope.b_usuario1.fecnac} <br>
				Usuario: ${requestScope.b_usuario1.usuario} <br>
				Clave:  ${requestScope.b_usuario1.clave} <br><br><hr>
				
				Sus datos recuperado de la sesión (Atributos que han sido cargados a la sesión):<br>
				Nombre: ${sessionScope.b_usuario2.nombre} <br>
				Direccion: ${sessionScope.b_usuario2.direccion} <br>
				Distrito: ${sessionScope.b_usuario2.distrito} <br>
				Telefono: ${sessionScope.b_usuario2.telefono} <br>
				Fecha N: ${sessionScope.b_usuario2.fecnac} <br>
				Usuario: ${sessionScope.b_usuario2.usuario} <br>
				Clave:  ${sessionScope.b_usuario2.clave} <br><br>
			</td>
		</tr>
		<tr>
			<!-- Aquí va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>