<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Employee</legend>
		<table border="1">

			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Salary</th>
				<th>action</th>
			</tr>
			<c:forEach var="e" items="${list}">
				<tr>
				  <td>${e.empid}</td>
				  <td>${e.empname}</td>
				  <td>${e.sal}</td>
				  <td>
				    <a href="edit/${e.empid}">Edit</a>
				    <a href="delete/${e.empid}">Delete</a>
				  </td>
				</tr>
			</c:forEach>
		</table>
		<a href="addEmp">Add New Employee</a>
	</fieldset>

</body>
</html>