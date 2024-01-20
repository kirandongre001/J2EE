package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Admin;
import com.demo.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@GetMapping("/admin")
	public ModelAndView showAdminLogin(HttpSession ses) {
		return new ModelAndView("register","s","add admin");
	}
	
	@PostMapping("/register")
	public ModelAndView register(@RequestParam String aname,@RequestParam String password,HttpSession session)
	{
		Admin ad=new Admin(aname,password);
		as.register(ad);
			return new ModelAndView("login","s","Admin Added");
		
	}
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String aname,@RequestParam String password,HttpSession session)
	{
		Admin a=as.validate(aname,password);
		if(a!=null)
		{
			session.setAttribute("admin", a);
			return new ModelAndView("redirect:/employee/getemployees");
		}
		else {
			String s="Wrong Credentials";
			return new ModelAndView("login","s",s);
		}
	}
	

}
