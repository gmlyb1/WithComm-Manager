package com.soft.controller;

import javax.inject.Inject;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.MemberService;
import com.soft.vo.memberVO;

@Controller
public class MemberController {

	@Inject
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 회원가입 페이지 처리
	@RequestMapping(value = "/account/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {

	}
	
	// 회원가입 액션
	@RequestMapping(value = "/account/register" , method = RequestMethod.POST)
	public String postRegister(memberVO vo, RedirectAttributes rttr) throws Exception {
		
		int result = memberService.idChk(vo);
		try {
			if(result == 1) {
				return "/account/registe";
			}else if(result ==0) {
				memberService.register(vo);
			}
		memberService.register(vo);
		rttr.addFlashAttribute("msg", "회원가입을 완료했습니다.");

		}catch (Exception e) {
			throw new RuntimeException(); 
		}
		return "redirect:/home";
	}
	
	// 로그인 페이지 처리
	@RequestMapping(value = "/account/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		return "/account/login";
	}
	
	
	// 로그인 
	@RequestMapping(value ="/account/login" , method=RequestMethod.POST)
	public String login(memberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
			
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(6000);
		memberVO login = memberService.login(vo);
		
		if(login == null)  {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", "아이디와 비밀번호를 다시 확인하세요!");
			return "redirect:/account/login";
		} else {
			session.setAttribute("member", login);
			rttr.addFlashAttribute("msg", "로그인에 성공하였습니다.");
			return "redirect:/home";
		}
	}
	
	// 로그아웃
	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();

		return "redirect:/account/login";
	}
	
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value = "/account/passChk" , method = RequestMethod.POST) 
	public int passChk(memberVO vo) throws Exception {
		int result = memberService.passChk(vo);
		return result;
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/account/idChk" , method=RequestMethod.POST) 
	public int idChk(memberVO vo) throws Exception {
		int result = memberService.idChk(vo);
		return result;
	}
	
}