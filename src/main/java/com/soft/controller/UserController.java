package com.soft.controller;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.serviceInterFace.UserService;
import com.soft.vo.UserVO;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/account/register", method=RequestMethod.GET)
	public String register() {
		return "/account/register";
	}
	
	
	@RequestMapping(value ="/account/login",method=RequestMethod.GET)
	public String login() {
		return "/account/login";
	}
	
	@RequestMapping(value= "/account/getIdCnt", method = RequestMethod.POST)
	@ResponseBody
	public String loginCntReset(@RequestBody String filterJSON, HttpServletResponse response, ModelMap model) throws Exception{
		
		  JSONObject resMap = new JSONObject();
		
		  try {
			  	ObjectMapper mapper = new ObjectMapper();
			  	UserVO searchVO = (UserVO) mapper.readValue(filterJSON, new TypeReference<UserVO>() {
				});
			  	
			  	int idCnt = userService.getIdCnt(searchVO);
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
	
	// 회원가입 등록 컨트롤러
	@RequestMapping(value= "/account/register_action",method= RequestMethod.POST)
	public String resgister_action(@ModelAttribute("searchVO") UserVO searchVO, HttpServletRequest request, RedirectAttributes redirect) {
		
		try {
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				Date time = new Date();
				String time1 = format1.format(time);
				searchVO.setUserRegDate(time1);
				String encrypt = encryptPassword(searchVO.getUserPw().trim());
				searchVO.setUserPw(encrypt);
				userService.insertMember(searchVO);
				redirect.addFlashAttribute("msg","회원가입이 완료되었습니다.");
				
		} catch (Exception e) {
				redirect.addFlashAttribute("msg", "오류가 발생되었습니다.");
		}

		return "redirect:/";
	}

	public static String encryptPassword(String data) throws Exception {
		if(data == null ) {
			return "";
		}
		
		byte[] plainText = null; // 평문
		byte[] hashValue = null; // 해쉬값
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		hashValue = md.digest(plainText);
		
		return new String(Base64.encodeBase64(hashValue));
		
		
	}
	
	
}
