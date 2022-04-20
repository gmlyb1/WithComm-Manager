package com.soft.controller;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.AccountService;
import com.soft.vo.LoginVO;
import com.soft.vo.memberVO;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	//로그인 
	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
	public String loginPage() throws Exception{
		
		return "/account/login";
	}
	
	//로그인 처리
	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	public String loginAction(memberVO VO, HttpSession session, Model model) throws Exception {
		List loginList = accountService.memLogin(VO);
		
		memberVO resultVO = (memberVO)loginList.get(0);
		int result = (int)loginList.get(1);
		
		// 로그인 세션
		session.setAttribute("result", result);
		
		if(resultVO != null) {
			session.setAttribute("resultVO", resultVO);
			session.setAttribute("me_id", resultVO.getMe_id());
		}

	return "redirect:/home";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		session.invalidate();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script>alert('로그아웃 되었습니다'); location.href='/account/login';</script>");
		out.flush();
	}
	
	// 회원가입 - 처리
	@RequestMapping(value = "/account/register" , method = RequestMethod.POST)
	public String RegisterID(MultipartHttpServletRequest multirequest, Model model) throws Exception {
		
		int checkID = accountService.checkMemId(Integer.parseInt(multirequest.getParameter("me_id")));
		
		if(checkID == 1) {
			model.addAttribute("checkID", checkID);
		}else {
			model.addAttribute("checkID", checkID);
		
		memberVO vo = new memberVO();
		
		vo.setMe_name((String) multirequest.getParameter("me_name"));
		vo.setMe_id((String) multirequest.getParameter("me_id"));
		vo.setMe_pwd((String) multirequest.getParameter("me_pwd"));
		vo.setMe_email((String) multirequest.getParameter("me_email"));
		vo.setMe_tel((String) multirequest.getParameter("me_tel"));
		accountService.memJoin(vo);		
		}
		
	return "redirect:/account/register";
	
	
	}
}