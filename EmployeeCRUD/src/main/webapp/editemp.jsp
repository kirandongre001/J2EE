<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateData" method="post">

Enter New EmpId:<input type="number" name="empId" id="id" value="${emp.empId}" placeholder="Enter-Id" readonly/>

Enter New EmpName:<input type="text" name="empName" id="name" value="${emp.empName}" placeholder="Enter-EmpName"/>

Enter New EmpSalary:<input type="number" name="sal" id="sal" value="${emp.sal}" placeholder="Enter-Salary"/>

<button type="submit">Update</button>

</form>

</body>
</html>