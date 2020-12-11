<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logueo de Usuarios</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form method="post" action="logueo">
		<table>
			<tr>
				<td colspan="2"><img alt="" src="imagenes/logo_tiny.png"></td>
			</tr>
			<tr>
				<td colspan="2"><font color="orange" size="5">Logueo de Usuarios</font></td>
			</tr>
			<tr>
				<td colspan="2" class="error_general"></td>
			</tr>
			<tr>
				<td class="etiqueta">Usuario:</td>
				<td class="control"><input type="text" size="10" name="usuario"></td>
			</tr>
			<tr>
				<td class="etiqueta">Clave:</td>
				<td class="control"><input type="password" size="10" name="clave"></td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit" value="Ingresar" /></td>
			<tr>
				<td colspan="2" class="error_general">${requestScope.mensaje}</td>
			</tr>
		</table>
	</form>
</body>
</html>