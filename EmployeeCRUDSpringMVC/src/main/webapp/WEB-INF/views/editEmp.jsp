<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/EmployeeCRUDSpringMVC/employee/updateEmp" method="post">
		<fieldset>
		<legend>Edit Employee</legend>
		Employee Id:<input type="text" name="empid" value="${e.empid}" readonly><br><br>
		Employee Name:<input type="text" name="empname" value="${e.empname}"><br><br>
		Employee Salary:<input type="text" name="sal" value="${e.sal}"><br><br>
		<button type="submit">Update</button>
		</fieldset>
	</form>
</body>
</html>