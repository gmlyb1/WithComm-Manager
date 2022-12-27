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
	
	@RequestMapping(value = "/manage" , method=RequestMethod.GET)
	public void ItemMain() {
	}
	
	@RequestMapping(value ="/itemInsert" , method=RequestMethod.GET)
	public void ItemInsertPOST() {
		
	}
	
	
	@RequestMapping(value = "/itemInsert" , method=RequestMethod.POST)
	public String ItemInsert(RedirectAttributes rttr,ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception 
	{
		try {
			itemService.itemInsert(itemVO, mpRequest);
			rttr.addFlashAttribute("msg", "��ǰ��Ͽ� �����Ͽ����ϴ�.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "��ǰ��� ó���߿� ������ �߻��Ͽ����ϴ�.");
		}
		System.out.println(itemVO);
		
		return "/item/itemInsert";
	}
}
