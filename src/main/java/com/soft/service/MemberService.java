package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface MemberService {

	// 회원가입
	public void register(memberVO vo) throws Exception;
	
	// 로그인
	public memberVO login(memberVO vo) throws Exception;
	
	// 비밀번호 체크
	public int passChk(memberVO vo) throws Exception;
	
	// 아이디 중복 체크
	public int idChk(memberVO vo) throws Exception;
}
