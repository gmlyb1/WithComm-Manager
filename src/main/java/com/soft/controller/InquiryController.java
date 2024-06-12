package com.soft.controller;

import java.lang.System.Logger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.InquiryService;
import com.soft.vo.InquiryVO;
import com.soft.vo.memberVO;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService inquiryService;
	
//	private static final Logger logger = LoggerFactory.getLogger(InquiryController.class);
	
	@RequestMapping(value="/list",method = {RequestMethod.GET, RequestMethod.POST})
	public String inquiryGET(InquiryVO vo,Model model) throws Exception{
		
		List<InquiryVO> inquiryList = inquiryService.selectInquiryList();
		
		model.addAttribute("inquiryList", inquiryList);
		
		return "/inquiry/list";
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String InquiryRead(@RequestParam("inq_no")int inq_no,InquiryVO vo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		model.addAttribute("read", inquiryService.selectInquiryDetail(inq_no));
		
		return "/inquiry/detail";
	}
	
	@RequestMapping(value = "/create" , method=RequestMethod.GET)
	public void MakeInquiryPage() {
		
	}
	
	@RequestMapping(value = "/create" , method=RequestMethod.POST)
	public String insertInquiry(InquiryVO vo, HttpServletRequest request, RedirectAttributes rttr, memberVO mVO) throws Exception
	{
		try {
			inquiryService.insertInquiry(vo);
			rttr.addFlashAttribute("msg", "글 작성을 완료하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("msg", "에러가 발생했습니다.");
			
		}
		
		return "redirect:/inquiry/list";
	}
	
	@RequestMapping(value = "/updateState", method=RequestMethod.POST)
	public String inquiryUpdate(InquiryVO vo, Model model , RedirectAttributes rttr) throws Exception
	{
		System.out.println("answerYn : " + vo.getAnswerYn());
		inquiryService.updateState(vo);
		
		return "redirect:/inquiry/list";
	}
}
