package com.demo.servlet;
import com.demo.service.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteemp")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("eid"));
		
		EmpService es=new EmpServiceImpl();
		es.deleteemp(id);
		
		RequestDispatcher rd=request.getRequestDispatcher("display");
		rd.forward(request, response);
	}

}
