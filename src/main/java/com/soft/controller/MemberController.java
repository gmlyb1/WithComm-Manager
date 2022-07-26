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
	
	// ȸ������ ������ ó��
	@RequestMapping(value = "/account/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {

	}
	
	// ȸ������ �׼�
	@RequestMapping(value = "/account/register" , method = RequestMethod.POST)
	public String postRegister(memberVO vo) throws Exception {
		int result = memberService.idChk(vo);
		try {
			if(result ==1 ) {
				return "/member/register";
			}else if(result == 0) {
				memberService.register(vo);
			}
		} catch (Exception e) {
				throw new RuntimeException();
		}
		return "redirect:/home";
	}
	
	// �α��� ������ ó��
	@RequestMapping(value = "/account/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		return "/account/login";
	}
	
	
	// �α��� 
	@RequestMapping(value ="/account/login" , method=RequestMethod.POST)
	public String login(memberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
			
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);
		memberVO login = memberService.login(vo);
		
		if(login == null)  {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", "���̵�� ��й�ȣ�� �ٽ� Ȯ���ϼ���!");
			return "redirect:/account/login";
		} else {
			session.setAttribute("member", login);
			rttr.addFlashAttribute("msg", "�α��ο� �����Ͽ����ϴ�.");
			return "redirect:/home";
		}
	}
	
	// �α׾ƿ�
	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();

		return "redirect:/account/login";
	}
	
	// ���̵� �ߺ� üũ
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/idChk" , method=RequestMethod.POST) public int
	 * idChk(memberVO vo) throws Exception { int result = memberService.idChk(vo);
	 * return result; }
	 * 
	 * // �н����� üũ
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping(value ="/passChk" , method = RequestMethod.POST) public int
	 * passChk(memberVO vo) throws Exception { int result =
	 * memberService.passChk(vo); return result; }
	 */
	
	
}