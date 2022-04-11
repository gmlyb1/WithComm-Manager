package com.soft.controller;



import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.service.UserService;
import com.soft.vo.UserVO;

@Controller
@RequestMapping("Index")
public class UserController {

	private static final Logger logger =
			LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService userService;
	
	//GET METHOD
	@RequestMapping("/join")
	public void UserJoinGET(UserVO vo) throws Exception{
		
		logger.info("회원가입 완료.");
		
	}
	
	// 정보처리 액션
	@RequestMapping("/joinAction")
	public void UserJoinPOST(UserVO vo) throws Exception{
		
		logger.info("로그인 처리한 값을 받아서, 회원가입 처리를 완료하였습니다.");
		
		System.out.println(vo);
		
		//로그인 처리함.
		//service.userJoin(vo);
		
		
	}
	
	
}
