package com.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {

	@Autowired
	
	@RequestMapping(value ="/account/register", method=RequestMethod.GET)
	public String register() {
		return "/account/register";
	}
	
	
	@RequestMapping(value ="/account/login",method=RequestMethod.GET)
	public String login() {
		return "/account/login";
	}
}
