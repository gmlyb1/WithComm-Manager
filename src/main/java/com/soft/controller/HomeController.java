package com.soft.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.BoardService;
import com.soft.service.MemberService;
import com.soft.service.NoticeService;
import com.soft.vo.NoticeVO;
import com.soft.vo.boardVO;
import com.soft.vo.memberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	@Inject
	private MemberService memberService;
	
	@Autowired
	@Inject
	private BoardService boardService;
	
	@Autowired
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(HttpServletResponse response,@ModelAttribute("vo")boardVO vo,Locale locale, HttpServletRequest request,Model model, HttpSession session, memberVO mvo) throws Exception {

		memberVO memberVO = (memberVO) session.getAttribute("memberVO");
		
		if(memberVO != null) {
			
			memberVO.setMe_id(memberVO.getMe_id());
			
		}
		
		memberVO memberSearch = memberService.memberInfoSearch(memberVO);

		model.addAttribute("memberVO", memberSearch);
		model.addAttribute("memberVO", memberVO);
		
		List<boardVO> HomeBoardList = boardService.HomeBoardList(vo);
		model.addAttribute("HomeBoardList", HomeBoardList);
		
		List<NoticeVO> HomeNoticeList = noticeService.HomeNoticeList();
		model.addAttribute("HomeNoticeList", HomeNoticeList);
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap || session == null) {
			model.addAttribute("msg", (String) inputFlashMap.get("msg"));
		}
		
		return "/home";
	}
	
}
	
