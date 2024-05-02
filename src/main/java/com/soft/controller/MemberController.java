package com.soft.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.MemberService;
import com.soft.util.FileUtils;
import com.soft.vo.memberVO;

@Controller
@RequestMapping("/account/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@Autowired
	private FileUtils fileUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 관리자 페이지 호출 메서드
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {

	}

	// 회원가입 - 관리자 페이지에서는 쓰이지 않음
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String postRegister(memberVO vo, RedirectAttributes rttr) throws Exception {
		
		try {
			memberService.register(vo);	
			memberService.memberChoice(vo);
			rttr.addFlashAttribute("msg", "회원가입이 완료되었습니다. 관리자의 권한 부여가 필요합니다.");
		}catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생하였습니다.");
		}
		
		
		return null;
	}
	
	// 로그인 페이지 get
	@RequestMapping(value = "/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		return "/account/login";
	}
	
	
	// 로그인 처리
	@RequestMapping(value ="/login" , method=RequestMethod.POST)
	public String login(HttpServletResponse response,memberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
			
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(6000);
		
		memberVO login = memberService.login(vo);
		
		if(login == null)  {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", "아이디 혹은 비밀번호를 한번 더 확인하여 주십시요.");
			return "redirect:/account/login";
		
		} else if(login.getAdminCk() == 0) {
			rttr.addFlashAttribute("msg", "권한이 없습니다. 관리자에게 문의해 주세요.");
			return "redirect:/account/login";
			
		} else {
			session.setAttribute("member", login);
			rttr.addFlashAttribute("msg", "로그인을 완료하였습니다.");
			return "redirect:/home";
		}
		
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,RedirectAttributes rttr) throws Exception {
		
			session.invalidate();

		return "redirect:/account/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/passChk" , method = RequestMethod.POST) 
	public int passChk(memberVO vo) throws Exception {
		int result = memberService.passChk(vo);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/idChk" , method=RequestMethod.POST) 
	public int idChk(memberVO vo) throws Exception {
		int result = memberService.idChk(vo);
		return result;
	}
	
	@RequestMapping(value = "/profile" , method=RequestMethod.GET)
	public String ProfileGET(HttpServletRequest request, Model model,HttpSession session,memberVO mVO) throws Exception {
		
		List<memberVO> memberList = memberService.memberManage(mVO);
		
		model.addAttribute("memberList", memberList);
		
		return "/account/profile";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String profileUpdateGET(memberVO mvo, Model model,RedirectAttributes rttr) throws Exception 
	{	
		model.addAttribute("update", memberService.memberManage(mvo));
		
		try {
			memberService.memberManage(mvo);
			rttr.addFlashAttribute("msg", "프로필 수정을 완료하였습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생하였습니다." + e);
		}
		
		
		return "/account/update";
	}
	
	
	@RequestMapping(value ="/update", method=RequestMethod.POST) 
	public String profileUpdatePOST(String me_id,HttpServletRequest request, RedirectAttributes rttr, Model model, HttpSession session,memberVO mVO) throws Exception {
		memberService.memberUpdate(me_id);
		session.invalidate();
		rttr.addFlashAttribute("msg", "프로필 수정을 완료하였습니다.");
		
		
		return "redirect:/account/login";
	}
	
	// ȸ�� Ż��(����)
	@RequestMapping(value = "/delete" ,method=RequestMethod.POST)
	public String memberDeletePOST(memberVO vo,RedirectAttributes rttr,int me_id) throws Exception{
		
		try {
			memberService.memberDelete(me_id);
			rttr.addFlashAttribute("msg", "프로필 삭제을 완료하였습니다..");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생하였습니다." + e);
		}
		
		return "/account/delete";
	}
	
	@RequestMapping(value="/delete" ,method=RequestMethod.GET)
	public void memberDeleteGET() throws Exception{
		
	}
	
	@RequestMapping(value = "/manage", method=RequestMethod.GET) 
	public String getManagePage(memberVO mVO, HttpServletRequest request, Model model) throws Exception {
		
		List<memberVO> memberList = memberService.memberManage(mVO);
		model.addAttribute("memberList", memberList);
		
		return "/account/manage";
	}
	
	//관리자지정
	@RequestMapping(value="/selectManager", method=RequestMethod.POST)
	public String selectManager(memberVO mVO, HttpServletRequest request, Model model,RedirectAttributes rttr) throws Exception 
	{
		logger.debug("mVO : {} " , mVO);
		try {
			memberService.selectManage(mVO);
		} catch (Exception e) {
			e.printStackTrace();
		}


			
		return "redirect:/account/manage";
	}

	//회원 상태 처리
	@RequestMapping(value="/state", method=RequestMethod.POST)
	public String stateChk(memberVO mVO, HttpServletRequest request, Model model,RedirectAttributes rttr) throws Exception 
	{
		logger.debug("mVO : {} " , mVO);
		try {
			memberService.stateChk(mVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/account/manage";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String AccountCreateGET(RedirectAttributes rttr,Model model, memberVO vo) {
		
		try {
			memberService.insertAccount(vo);
			rttr.addFlashAttribute("msg", "회원등록이 완료되었습니다.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생했습니다."+e);
		}
		
		return "/account/create";
	}
	
	// 비밀번호 초기화
	@RequestMapping(value="/pwValid", method=RequestMethod.POST)
	public String pwValidation(memberVO mVO, HttpServletRequest request, Model model, RedirectAttributes rttr) throws Exception
	{
		try {
			memberService.pwValidation(mVO);
			rttr.addFlashAttribute("msg", "비밀번호가 초기화 되었습니다.");
		}catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생했습니다."+e);
		}
		
		return "redirect:/account/manage";
	}
	

}