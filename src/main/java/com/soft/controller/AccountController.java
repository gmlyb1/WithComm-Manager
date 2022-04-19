package com.soft.controller;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	
	
	// ȸ������ �޼���
	@RequestMapping(value ="/account/register", method=RequestMethod.GET)
	public String register() {
		return "/account/register";
	}
	
	// ȸ������ �׼� �޼���
	@RequestMapping(value="/account/register_action", method=RequestMethod.POST)
	public String register_action(@ModelAttribute("searchVO") memberVO searchVO,HttpServletRequest request, RedirectAttributes redirect) {
		
		try {
				
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date time = new Date();
			String time1 = format1.format(time);
			searchVO.setMe_regDate(time1);
			String encrypt = encryptPassword(searchVO.getMe_pwd().trim());
					searchVO.setMe_pwd(encrypt);
					
			accountService.insertMember(searchVO);
			redirect.addFlashAttribute("msg", "ȸ�������� �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			redirect.addFlashAttribute("msg", "������ �߻��Ǿ����ϴ�.");
		}
		return "redirct:/home";
	}
	
	public static String encryptPassword(String data) throws Exception {
		if(data == null ) {
			return "";
		}
		
		byte[] plainText = null; // ��
		byte[] hashValue = null; // �ؽ���
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		hashValue = md.digest(plainText);
		
		return new String(Base64.encodeBase64(hashValue));
	}
	
	//�α��� �޼���
	@RequestMapping(value ="/account/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request, Model model, memberVO searchVO, @CookieValue(value="CustomCheck", required=false) Cookie rememberCookie) {
		
		if(rememberCookie != null) {
			model.addAttribute("rememberCookie", rememberCookie);
		}
		
		return "/account/login";
	}
	
	
	//�α��� �׼� �޼���
	@RequestMapping(value = "/account/login_action",method=RequestMethod.POST)
	public String actionLogin(@ModelAttribute("searchVO") memberVO searchVO, HttpServletRequest request,
			HttpSession session, RedirectAttributes redirectAttributes, HttpServletResponse httpServletResponse,
			ModelMap model) throws Exception{
		
		String encrypt = encryptPassword(searchVO.getMe_pwd().trim());
		searchVO.setMe_pwd(encrypt);
		
		memberVO loginInfo = accountService.actionLogin(searchVO);
		
		if(loginInfo == null) {
			redirectAttributes.addFlashAttribute("msg", "�α����� �����Ͽ����ϴ�.");
			return "redirect:/account/login.do";
		}
		
		Cookie rememberCookie = new Cookie("CustomCheck", loginInfo.getMe_id());
		rememberCookie.setPath("/");
		if(searchVO.isCustomCheck()) {
			rememberCookie.setMaxAge(60*60*24*7);
		} else {
			rememberCookie.setMaxAge(0);
		}
		httpServletResponse.addCookie(rememberCookie);
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginInfo.getMe_id());
		loginVO.setName(loginInfo.getMe_name());
		loginVO.setPwd(loginInfo.getMe_pwd());
		loginVO.setAuth(loginInfo.getMe_auth());
		loginVO.setEmail(loginInfo.getMe_email());
		loginVO.setTel(loginInfo.getMe_tel());
		loginVO.setLatest_login(loginInfo.getMe_latest_login());
		loginVO.setRegdate(loginInfo.getMe_regDate());
		
		session.setAttribute("loginVO", loginVO);
		
		accountService.updateLastLogin(searchVO);
		
		Object URL = session.getAttribute("URL");
		
		String requestURL = "/";
		if(StringUtils.isNotBlank((String) URL)) requestURL = (String)URL;
		
		
		return "redirect:/home";
	}

	//�α׾ƿ� �޼���
	@RequestMapping(value = "/account/logout", method=RequestMethod.GET)
		public String logout(HttpServletRequest request, SessionStatus status, HttpSession session, HttpServletResponse response,ModelMap model) throws Exception {
		
		Object URL = session.getAttribute("URL");
		status.setComplete();
		session.removeAttribute("loginVO");
		session.invalidate();

		//response.setContentType("text/html; charset=utf-8");
		//PrintWriter out = response.getWriter();
		
		String requestURL = "/";
		if(StringUtils.isNotBlank((String)URL)) requestURL = (String)URL;
		
		return "redirect:"+requestURL;
	}
	
	
	@RequestMapping(value= "/account/getIdCnt", method = RequestMethod.POST)
	@ResponseBody
	public String loginCntReset(@RequestBody String filterJSON, HttpServletResponse response, ModelMap model) throws Exception{
		
		  JSONObject resMap = new JSONObject();
		
		  try {
			  	ObjectMapper mapper = new ObjectMapper();
			  	memberVO searchVO = (memberVO) mapper.readValue(filterJSON, new TypeReference<memberVO>() {
				});
			  	
			  	int idCnt = accountService.getIdCnt(searchVO);
			  	resMap.put("res", "ok");
			  	resMap.put("idCnt", idCnt);
		  
		  } catch (Exception e) {
			  System.out.println(e.toString());
			  resMap.put("res", "error");
		
		  }
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  out.print(resMap);
		  
		  return null;
	}
	
	



	
	
}
