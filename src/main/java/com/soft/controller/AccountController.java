package com.soft.controller;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.AccountService;
import com.soft.vo.LoginVO;
import com.soft.vo.memberVO;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AccountController {

	@Inject
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	// 로그아웃 
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		
		session.invalidate();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script>alert('로그아웃 되었습니다.'); location.href='/account/login';</script>");
		out.flush();
	}
	
	// 로그인 
	@RequestMapping(value ="/account/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		
		return "/account/login";
		
	}
	
	
	// 로그인 액션
	@RequestMapping(value = "/account/login" , method=RequestMethod.POST)
	public String loginAction(memberVO vo, HttpSession session, Model model) throws Exception {
		List loginMem = accountService.memLogin(vo);
		memberVO resultVO = (memberVO)loginMem.get(0);
		int result = (Integer)loginMem.get(1);
		
		session.setAttribute("result", result);
		
		if(resultVO != null) {
			session.setAttribute("resultVO", resultVO);
			session.setAttribute("me_id", resultVO.getMe_id());
		}
		
		return "redirect:/home";
	}
	
	// 회원가입 - 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Register(MultipartHttpServletRequest multiRequest, Model model) throws Exception {
		int checkID = accountService.checkMemId(Integer.parseInt(multiRequest.getParameter("me_id")));
		
		if(checkID == 1) {
			model.addAttribute("checkID", checkID);
			
		}else{
			model.addAttribute("checkID", checkID);
		
			
		memberVO vo = new memberVO();
		
		vo.setMe_name((String) multiRequest.getParameter("me_id"));
		vo.setMe_id((String) multiRequest.getParameter("me_id"));
		vo.setMe_pwd((String) multiRequest.getParameter("me_pwd"));
		vo.setMe_email((String) multiRequest.getParameter("me_email"));
		vo.setMe_tel((String) multiRequest.getParameter("me_tel"));
		
		accountService.memJoin(vo);
		}
		
		return "redirect:/account/register";
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/updateMem", method=RequestMethod.POST)
	public String mem_update(MultipartHttpServletRequest multiRequest, Model model) throws Exception {
		
		memberVO vo = new memberVO();
		
		vo.setMe_id((String) multiRequest.getParameter("me_id"));
		vo.setMe_id((String) multiRequest.getParameter("me_id"));
		vo.setMe_pwd((String) multiRequest.getParameter("me_pwd"));
		vo.setMe_email((String) multiRequest.getParameter("me_email"));
		vo.setMe_tel((String) multiRequest.getParameter("me_tel"));
		vo.setMe_auth((String) multiRequest.getParameter("me_auth"));
		vo.setMe_latest_login((String) multiRequest.getParameter("me_latest_login"));
		vo.setMe_regDate((String) multiRequest.getParameter("me_regDate"));
		vo.setMe_id_yn((String) multiRequest.getParameter("me_id_yn"));
		vo.setMe_delete_yn((String) multiRequest.getParameter("me_id_yn"));
		
		int result = accountService.memUpdate(vo);
		
		model.addAttribute("updateMem_result", result);
		
		return "redirect:/infoMem";
	}
	
}