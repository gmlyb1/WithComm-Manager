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
import com.soft.service.EmailService;
import com.soft.service.InquiryService;
import com.soft.service.MemberService;
import com.soft.service.NoticeService;
import com.soft.service.VisitCountService;
import com.soft.vo.InquiryVO;
import com.soft.vo.MailVO;
import com.soft.vo.NoticeVO;
import com.soft.vo.VisitCountVO;
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
	
	@Autowired
	@Inject
	private InquiryService inquiryService;
	
	@Autowired
	@Inject
	private EmailService emailService;
	
	@Autowired
	@Inject
	private VisitCountService visitCountService;
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(HttpServletResponse response,@ModelAttribute("vvo")VisitCountVO vvo,@ModelAttribute("mailvo")MailVO mailvo,@ModelAttribute("nvo")NoticeVO nvo,@ModelAttribute("bvo")boardVO bvo,@ModelAttribute("ivo")InquiryVO ivo,Locale locale, HttpServletRequest request,Model model, HttpSession session, @ModelAttribute("mvo")memberVO mvo) throws Exception {

		memberVO memberVO = (memberVO) session.getAttribute("memberVO");
		
		if(memberVO != null) {
			
			memberVO.setMe_id(memberVO.getMe_id());
			
		}
		
		
		memberVO memberSearch = memberService.memberInfoSearch(memberVO);

		model.addAttribute("memberVO", memberSearch);
		model.addAttribute("memberVO", memberVO);

		//대쉬보드 - 게시판 건수	리스트
		List<boardVO> HomeBoardList = boardService.HomeBoardList(bvo);
		model.addAttribute("HomeBoardList", HomeBoardList);
		
		//대쉬보드 - 공지사항 건수 리스트
		List<NoticeVO> HomeNoticeList = noticeService.HomeNoticeList();
		model.addAttribute("HomeNoticeList", HomeNoticeList);
		
		//대쉬보드 - 회원정보 리스트
		List<memberVO> HomeMemberList = memberService.HomeMemberList(memberVO);
		model.addAttribute("HomeMemberList", HomeMemberList);
		
		//대쉬보드 - 운영자 리스트
		List<memberVO> HomeGmList = memberService.HomeGmList(memberVO);
		model.addAttribute("HomeGmList", HomeGmList);
		
		//대쉬보드 - 게시판 건수(일,월,주,년)
		boardVO boardCnts = boardService.boardCnt(bvo);
		model.addAttribute("boardCnt", boardCnts);
		
		//대쉬보드 - 공지사항 건수(일,월,주,년)
		NoticeVO noticeCnt = noticeService.noticeCnt(nvo);
		model.addAttribute("noticeCnt", noticeCnt);
		
		//대쉬보드 - 1:1문의 건수(일,월,주,년)
		InquiryVO inquiryCnt = inquiryService.inquiryCnt(ivo);
		model.addAttribute("inquiryCnt", inquiryCnt);
		
		//대쉬보드 - 접속자 건수(일,월,주,년)
		memberVO memberCnt = memberService.memberCnt(mvo);
		model.addAttribute("memberCnt", memberCnt);
		
		memberVO memberRegisterAprvSttsCnt = memberService.memberRegisterAprvSttsCnt(mvo);
		model.addAttribute("memberRegisterAprvSttsCnt", memberRegisterAprvSttsCnt);
		
		InquiryVO inquiryAprvSttsCnt = inquiryService.inquiryAprvSttsCnt(ivo);
		model.addAttribute("inquiryAprvSttsCnt", inquiryAprvSttsCnt);
		
		MailVO mailAprvSttsCnt = emailService.mailAprvSttsCnt(mailvo);
		model.addAttribute("mailAprvSttsCnt", mailAprvSttsCnt);
		
		VisitCountVO visitAprvSttsCnt = visitCountService.visitAprvSttsCnt(vvo);
		model.addAttribute("visitAprvSttsCnt", visitAprvSttsCnt);
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap || session == null) {
			model.addAttribute("msg", (String) inputFlashMap.get("msg"));
		}
		
		return "/home";
	}
	
}
	
