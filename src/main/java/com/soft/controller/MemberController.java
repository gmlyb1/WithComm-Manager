package com.soft.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.MemberService;
import com.soft.vo.memberVO;

@Controller
@RequestMapping("/account/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
//	@Autowired(required = false)
//	BCryptPasswordEncoder passEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 회원가입 페이지 처리
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {

	}
	
	// 회원가입 액션
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String postRegister(memberVO vo, RedirectAttributes rttr) throws Exception {
		
		int result = memberService.idChk(vo);
		try {
			if(result == 1) {
				return "/account/register";
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
	@RequestMapping(value = "/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		return "/account/login";
	}
	
	
	// 로그인 
	@RequestMapping(value ="/login" , method=RequestMethod.POST)
	public String login(memberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
			
//		String inputPass = vo.getMe_pwd();
//		String pass = passEncoder.encode(inputPass);
//		vo.setMe_pwd(pass);
		
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
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();

		return "redirect:/account/login";
	}
	
	// 패스워드 체크
	@ResponseBody
	@RequestMapping(value = "/passChk" , method = RequestMethod.POST) 
	public int passChk(memberVO vo) throws Exception {
		int result = memberService.passChk(vo);
		return result;
	}
	
	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idChk" , method=RequestMethod.POST) 
	public int idChk(memberVO vo) throws Exception {
		int result = memberService.idChk(vo);
		return result;
	}
	
	// 프로필 목록
	@RequestMapping(value = "/profile" , method=RequestMethod.GET)
	public String ProfileGET(HttpServletRequest request, Model model,HttpSession session,memberVO mVO) throws Exception {
		
		List<memberVO> memberList = memberService.memberManage(mVO);
		
		model.addAttribute("memberList", memberList);
		
		return "/account/profile";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String profileUpdateGET(memberVO mvo, Model model) throws Exception 
	{	
		model.addAttribute("update", memberService.memberManage(mvo));
		
		return "/account/update";
	}
	
	@RequestMapping(value ="/update", method=RequestMethod.POST) 
	public String profileUpdatePOST(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model, HttpSession session,memberVO mVO) {
			
		try {
			memberService.memberUpdate(mVO);
			redirectAttributes.addFlashAttribute("msg", "수정 하였습니다.");
			
		}catch (Exception e) {
			System.out.println(e.toString());
			redirectAttributes.addFlashAttribute("msg", "오류가 발생되었습니다.");
		}
		
		return "redirect:/account/profile";
	}
	
	// 회원 탈퇴(어드민)
	@RequestMapping(value = "/delete" ,method=RequestMethod.POST)
	public String memberDeletePOST(memberVO vo,RedirectAttributes rttr) throws Exception{
		
		try {
			memberService.memberDelete(vo.getMe_id());
			rttr.addFlashAttribute("msg", "회원 삭제가 완료되었습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생 되었습니다.");
		}
		
		return "redirect:/account/manage";
	}
	
	@RequestMapping(value="/delete" ,method=RequestMethod.GET)
	public void memberDeleteGET() throws Exception{
		
	}
	
//	@RequestMapping(value="/delete", method=RequestMethod.GET)
//	public void memberDeleteGET() throws Exception{
//		
//	}
	
	// 회원관리
	@RequestMapping(value = "/manage", method=RequestMethod.GET)
	public String memberList(@ModelAttribute("mVO") memberVO mVO, HttpServletRequest request, Model model) throws Exception {

		Map<String, ?>inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap) {
			model.addAttribute("msg", (String)inputFlashMap.get("msg"));
		}
		
		List<memberVO> memberList = memberService.memberManage(mVO);
		
		model.addAttribute("memberList", memberList);
		
		return "/account/manage";
	}

}