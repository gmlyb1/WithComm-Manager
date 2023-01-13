package com.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.ItemService;
import com.soft.vo.ItemVO;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/index" , method=RequestMethod.GET)
	public void ItemMain() {
	}
	
	@RequestMapping(value ="/goods/register" , method=RequestMethod.GET)
	public void ItemRegisterGET() {
		
	}
	
	@RequestMapping(value = "/goods/register" , method=RequestMethod.POST)
	public String ItemRegisterPOST(RedirectAttributes rttr,ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception 
	{
		System.out.println(itemVO);
		
		return "/item/itemInsert";
	}
}
