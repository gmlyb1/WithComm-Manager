package com.soft.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.service.UserService;
import com.soft.vo.UserVO;

@Controller
@RequestMapping(value="/index")
public class UserController {

	private static final Logger logger = 
			LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	@RequestMapping("/join")
	public void UserJoinGET(UserVO vo) throws Exception {
		logger.info("회원가입 페이지.");
	}
	
	@RequestMapping("/joinAction")
	public void UserJoinPOST(UserVO vo) throws Exception {
		logger.info("회원가입이 완료되었습니다."+vo);
		
		// 로그인 처리
		//userService.userJoin(vo);
	}
	
	
}
