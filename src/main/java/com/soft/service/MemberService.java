package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface MemberService {

	// 회원가입
	public void register(memberVO vo) throws Exception;
	
	// 로그인
	public memberVO login(memberVO vo) throws Exception;
	
	
}
