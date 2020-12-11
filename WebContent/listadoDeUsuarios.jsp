<!-- 1. Hacemos referencia a las librerias de jstl -->
<!--   
	El uri es el nombre logico de la libreria de etiquetas que queremos referenciar
	El prefijo es el nombre corto del uri
 -->
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
			<!-- Aqui va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!-- Aqui va el cuerpo -->
			<td class="control">
				<form method="post" action="usuario.do">
					<input type="hidden" name="operacion" value="lista">
					<table>
						<tr>
							<td class="control"><fmt:message key="listado.nombre" /></td>
							<td><input type="text" name="nombre"></td>
							<td><input type="submit" name="boton01" value="listar"></td>
						</tr>
					</table>
					<c:if test="${requestScope.li_usuarios!=null}">
						<!-- Lista de Usuarios -->
						<table>
							<tr class="grilla_cabecera">
								<td><fmt:message key="listado.nombre" /></td>
								<td>Direccion</td>
								<td>Fecha de Nacimiento</td>
								<td>Eliminar</td>
								<td>Modificar</td>
							</tr>
							<c:forEach var="usu" items="${requestScope.li_usuarios}">
								<tr class="grilla_campo">
									<td>${usu.nombre }</td>
									<td>${usu.direccion }</td>
									<td><fmt:formatDate value="${usu.fecnac}" type="date" dateStyle="full" />
									</td>
									<td align="center"><a
										href="usuario.do?operacion=elimina&usuario=${usu.usuario}">E</a>
									</td>
									<td align="center"><a
										href="usuario.do?operacion=cargaModifica&usuario=${usu.usuario}">M</a>
									</td>
								</tr>
							</c:forEach>
							<tr class="control">
								<td colspan="5" align="right">
									<a href="nuevoUsuario.jsp">NuevoUsuario</a>
								</td>
							</tr>
						</table>
					</c:if>
				</form>
			</td>
		</tr>
		<tr>
			<!-- Aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>