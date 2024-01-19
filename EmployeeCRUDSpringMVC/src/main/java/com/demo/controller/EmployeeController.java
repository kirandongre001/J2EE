package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.demo.service.EmployeeService;

@Controller
public class EmployeeController {
 @Autowired
  private EmployeeService es;
 
 
}
