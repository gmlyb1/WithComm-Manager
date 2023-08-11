package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface MemberService {

	public void register(memberVO vo) throws Exception;
	
	public memberVO login(memberVO vo) throws Exception;
	
	public int passChk(memberVO vo) throws Exception;
	
	public int idChk(memberVO vo) throws Exception;
	
	public memberVO memberInfoSearch(memberVO mVO)throws Exception;
	
	public void memberUpdate(String me_id) throws Exception;
	
	public List<memberVO> memberManage(memberVO mVO)throws Exception;
	
	public void memberDelete(int me_id) throws Exception;

	public void updateImg(String memberImg, String me_id);
	
	// 관리자 지정
	public void selectManage(memberVO mvo) throws Exception;
	
	public void stateChk(memberVO mvo) throws Exception;
	
	public void insertAccount(memberVO vo) throws Exception;

	public int memberChoice(memberVO vo) throws Exception;
	
	// 대쉬보드 멤버리스트,운영자리스트
	public List<memberVO> HomeMemberList(memberVO vo) throws Exception;
	
	public List<memberVO> HomeGmList(memberVO vo) throws Exception;
	
	// 비밀번호 초기화
	public void pwValidation(memberVO vo) throws Exception;
}
