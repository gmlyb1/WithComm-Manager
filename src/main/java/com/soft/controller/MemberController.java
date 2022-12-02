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
import org.springframework.security.crypto.bcrypt.BCrypt;
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
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// ȸ������ ������ ó��
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {

	}
	
	// ȸ������ �׼�
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String postRegister(memberVO vo, RedirectAttributes rttr) throws Exception {
		
		try {
			memberService.register(vo);
			rttr.addFlashAttribute("msg", "ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}catch (Exception e) {
			rttr.addFlashAttribute("msg", "������ �߻��Ͽ����ϴ�.");
		}
		
		
		return null;
	}
	
	// �α��� ������ ó��
	@RequestMapping(value = "/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		return "/account/login";
	}
	
	
	// �α��� 
	@RequestMapping(value ="/login" , method=RequestMethod.POST)
	public String login(memberVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
			
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(6000);
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
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();

		return "redirect:/account/login";
	}
	
	// �н����� üũ
	@ResponseBody
	@RequestMapping(value = "/passChk" , method = RequestMethod.POST) 
	public int passChk(memberVO vo) throws Exception {
		int result = memberService.passChk(vo);
		return result;
	}
	
	// ���̵� �ߺ� üũ
	@ResponseBody
	@RequestMapping(value = "/idChk" , method=RequestMethod.POST) 
	public int idChk(memberVO vo) throws Exception {
		int result = memberService.idChk(vo);
		return result;
	}
	
	// ������ ���
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
	
	@RequestMapping(value="/pwCheck" , method=RequestMethod.POST)
	@ResponseBody
	public int pwCheck(memberVO memberVO) throws Exception {
		String me_pwd = memberService.pwCheck(memberVO.getMe_email());
		if(memberVO == null || !BCrypt.checkpw(memberVO.getMe_pwd(), me_pwd)) {
		return 0;
	}
	return 1;
}
	
	@RequestMapping(value ="/update", method=RequestMethod.POST) 
	public String profileUpdatePOST(String me_email,String me_pwd1,HttpServletRequest request, RedirectAttributes rttr, Model model, HttpSession session,memberVO mVO) throws Exception {
		String hashedPw = BCrypt.hashpw(me_pwd1, BCrypt.gensalt());
		memberService.memberUpdate(me_email, hashedPw);
		session.invalidate();
		rttr.addFlashAttribute("msg", "���� ������ �Ϸ�Ǿ����ϴ�. �ٽ� �α������ּ���");
		
		
		return "redirect:/account/login";
	}
	
	// ȸ�� Ż��(����)
	@RequestMapping(value = "/delete" ,method=RequestMethod.POST)
	public String memberDeletePOST(memberVO vo,RedirectAttributes rttr) throws Exception{
		
		try {
			memberService.memberDelete(vo.getMe_id());
			rttr.addFlashAttribute("msg", "ȸ�� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			rttr.addFlashAttribute("msg", "������ �߻� �Ǿ����ϴ�.");
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
	
	// ȸ������
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