package com.demo.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
public class MyLoginController {
	
	@Autowired
	LoginService loginservice;
	
	
	
	public MyLoginController(LoginService loginservice) {
		super();
		System.out.println("Inside Controller");
	}



	@GetMapping("/")
	public String Login()
	{
		return "login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String uname,@RequestParam String password,HttpSession session)
	{
		MyUser user=loginservice.validate(uname,password);
		if(user!=null)
		{
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/getproducts/");
		}
		else {
			String s="Wrong credentials, pls renter";
			return new ModelAndView("login","s",s);
		}

	}
	
}
