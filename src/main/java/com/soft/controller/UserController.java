package com.soft.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.vo.UserVO;

import net.sf.json.JSONObject;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Controller
public class UserController {

	@Autowired
	
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
		/*
		 * JSONObject resMap = new JSONObject();
		 * 
		 * try { ObjectMapper mapper = new ObjectMapper(); UserVO searchVO = (UserVO)
		 * mapper.readValue(filterJSON, new TypeReference() { }); int idCnt = } catch
		 * (Exception e) { }
		 */
		
		return null;
	}
}
