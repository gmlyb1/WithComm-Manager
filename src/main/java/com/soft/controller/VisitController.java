package com.soft.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.service.VisitCountService;
import com.soft.vo.VisitCountVO;


@Controller
@RequestMapping("/visit/*")
public class VisitController {

	@Inject
	private VisitCountService service;
	
	private static final Logger logger = LoggerFactory.getLogger(VisitController.class);
	
	
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String getClientList(VisitCountVO vvo,Model model) throws Exception {
		
		List<VisitCountVO> visitList = service.selectVisitList(vvo);
		
		model.addAttribute("visitList", visitList);
		
		return "/visit/list";
	}
}
