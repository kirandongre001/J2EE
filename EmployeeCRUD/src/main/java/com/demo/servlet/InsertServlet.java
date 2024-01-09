package com.demo.servlet;
import com.demo.model.*;
import com.demo.service.EmpService;
import com.demo.service.EmpServiceImpl;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insertData")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
  
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int empId=Integer.parseInt(request.getParameter("empId"));
           String empName=request.getParameter("empName");
           double sal=Double.parseDouble(request.getParameter("sal"));
           
           EmpService es=new EmpServiceImpl();
           
           Employee e=new Employee(empId,empName,sal);
           
           es.insertEmployee(e);
           RequestDispatcher rs=request.getRequestDispatcher("display");
           rs.forward(request, response);
	}

}
