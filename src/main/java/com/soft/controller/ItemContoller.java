package com.soft.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.BoardService;
import com.soft.service.ItemService;
import com.soft.vo.ItemVO;

@Controller
public class ItemContoller {
	
	@Autowired
	//@Inject
	private ItemService itemService;
	
	@Inject
	private static final Logger logger = LoggerFactory.getLogger(ItemContoller.class);
	
	
	// 상품 리스트 GET
	@RequestMapping(value= "/item/list", method=RequestMethod.GET)
	public void itemListGET() {
		
	}
	
	// 상품 리스트 POST
	@RequestMapping(value = "/item/list", method=RequestMethod.POST)
	public String itemListPOST() {
		return "/item/list";
	}
	
	
	// 상품등록 GET
	@RequestMapping(value = "/item/insert", method=RequestMethod.GET)
	public void itemInsertGET() {
		
	}
	
	
	// 상품 등록
	@RequestMapping(value ="/item/insert", method = RequestMethod.POST) 
		public String itemInsertPOST(ItemVO itemVO, MultipartHttpServletRequest request) throws Exception {
				
			itemService.itemInsert(itemVO, request);
			return "/item/insert";
		}
		
	}
	
