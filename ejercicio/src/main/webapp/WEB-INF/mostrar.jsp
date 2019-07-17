<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Mostrar personas</h2>
	<h2>hey ${nombre}</h2>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Genero</th>
			<th>Email</th>
		</tr>
		<c:forEach var="var" items="${list}">
			<tr>
				<td>${var.nombre}</td>
				<td>${var.apellido}</td>
				<td>${var.genero}</td>
				<td>${var.email}</td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>