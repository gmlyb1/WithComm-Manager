package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {


	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String inquiryGET() {
		
		
		return "/inquiry/list";
	}
	
	
	
}
