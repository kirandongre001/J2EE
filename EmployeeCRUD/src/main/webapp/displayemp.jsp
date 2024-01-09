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
  <table border="2">
   
    <tr>
     <th>Employee Id</th>
     <th>Employee Name</th>
     <th>Employee Salary</th>
     <th>actions</th>
    </tr>
  
   <tbody>
    <c:forEach var="emp" items="${list}">
    <tr>
     <td>${emp.empId}</td>
     <td>${emp.empName}</td>
     <td>${emp.sal}</td>
     <td>
     <a href="#">Delete</a>
     <a href="#">Edit</a>
     </td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="insert.jsp">Add new Employee</a>
</body>
</html>