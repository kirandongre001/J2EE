package com.demo.servlet;
import com.demo.service.*;
import com.demo.model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmpservlet
 */
@WebServlet("/updateData")
public class UpdateEmpservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid=Integer.parseInt(request.getParameter("empId"));
		String ename=request.getParameter("empName");
		double sal=Double.parseDouble(request.getParameter("sal"));
		
		EmpService eservice=new EmpServiceImpl();
		Employee e=new Employee(empid,ename,sal);
		eservice.updateemp(e);
		
		RequestDispatcher rd=request.getRequestDispatcher("display");
		rd.forward(request, response);
	}

}
