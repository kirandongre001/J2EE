
package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.demo.service.EmpService;

import com.demo.service.EmpServiceImpl;

import com.demo.model.*;


/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		EmpService eservice= new EmpServiceImpl();
		List<Employee>elist=eservice.displayAllEmp();
		elist.forEach(System.out::println);
		
		request.setAttribute("list", elist);
		
		RequestDispatcher rd=request.getRequestDispatcher("displayemp.jsp");
		
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

}
