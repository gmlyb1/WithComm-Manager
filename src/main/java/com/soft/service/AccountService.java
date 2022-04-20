package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface AccountService {

	// 중복확인
	public int checkMemId(int me_id) throws Exception;
	
	// 회원가입
	public void memJoin(memberVO vo) throws Exception;
	
	// 로그인
	public List loginMem(memberVO vo) throws Exception;
	
	// 회원정보
	public memberVO memInfo(int me_id)throws Exception;
	
	// 회원수정
	public int memUpdate(memberVO vo) throws Exception;
	
	// 회원탈퇴
	public int memDelete(memberVO vo) throws Exception;
	
	// 직원 리스트
	public List<memberVO> memList() throws Exception;
	
	
	
	
}
