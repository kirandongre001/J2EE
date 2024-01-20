package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Admin;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
 @Autowired
  private EmployeeService es;
 
 @GetMapping("/getemployees")
 public ModelAndView getemployee(HttpSession session)
 {
	 Admin a=(Admin) session.getAttribute("admin");
	 if(a!=null) {
		 System.out.println(a);
		 List<Employee> list=es.getAllEmployee();
		 list.forEach(System.out::println);
		 return new ModelAndView("displayEmp","list",list);
	 }
	 return new ModelAndView("redirect:/login/");
 }
 
 @GetMapping("/addEmp")
 public String addnewEmployee(HttpSession ses) {
	 Admin a=(Admin) ses.getAttribute("admin");
	 if(a!=null) {
		 return "addEmployee";
	 }
		 return ("redirect:/login/");
 }
 
 @PostMapping("/insertEmp")
 public ModelAndView insertemployee(@RequestParam int empid,@RequestParam String empname,@RequestParam double sal) {
	 Employee e=new Employee(empid,empname,sal);
	 es.insertemp(e);
	 
	 return new ModelAndView("redirect:/employee/getemployees");
 }
 
 @GetMapping("/edit/{empid}")
 public ModelAndView editEmployee(@PathVariable int empid)
 {
	 Employee e=es.getById(empid);
	 return new ModelAndView("editEmp","e",e);
 }
 
 @PostMapping("/updateEmp")
 public ModelAndView updateemployee(@RequestParam int empid,@RequestParam String empname,@RequestParam double sal) {
	 Employee e=new Employee(empid,empname,sal);
	 es.updateemp(e);
	 
	 return new ModelAndView("redirect:/employee/getemployees");
}
 
 @GetMapping("/delete/{empid}")
 public ModelAndView deleteEmployee(@PathVariable int empid)
 {
	 es.deleteById(empid);
	 return new ModelAndView("redirect:/employee/getemployees");
 }
}