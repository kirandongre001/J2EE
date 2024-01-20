<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertEmp" method="post">
		<fieldset>
		<legend>Add Employee</legend>
		Employee Id:<input type="text" name="empid" placeholder="Enter id"><br><br>
		Employee Name:<input type="text" name="empname" placeholder="Enter emp name"><br><br>
		Employee Salary:<input type="text" name="sal" ><br><br>
		<button type="submit">ADD</button>
		</fieldset>
	</form>
</body>
</html>