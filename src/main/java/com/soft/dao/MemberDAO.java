package com.soft.dao;

import java.util.List;


import com.soft.vo.memberVO;

public interface MemberDAO {


	// 회원가입
	public void register(memberVO vo) throws Exception;
	
	// 로그인
	public memberVO login(memberVO vo) throws Exception;
	
	// 비밀번호 체크
	public int passChk(memberVO vo) throws Exception;

	// 아이디 중복 체크
	public int idChk(memberVO vo) throws Exception;
	
	// 프로필
	public memberVO memberInfoSearch(memberVO mVO)throws Exception;
	
	// 프로필 수정
	public void memberUpdate(memberVO mVO) throws Exception;
	
	// 회원 관리
	public List<memberVO> memberManage(memberVO mVO)throws Exception;
	
	//회원 탈퇴(어드민)
	public void memberDelete(int me_id) throws Exception;
}
