package com.soft.dao;

import java.util.List;

import com.soft.vo.memberVO;

public interface AccountDAO {

	// 중복체크
	public int checkMemId(int me_id) throws Exception;
	
	// 회원가입
	public void joinMem(memberVO vo) throws Exception;
	
	// 로그인
	public List loginMem(memberVO vo) throws Exception;
	
	// 정보
	public memberVO infoMem(int me_id) throws Exception;
	
	// 수정
	public int updateMem(memberVO vo) throws Exception;
	
	// 탈퇴
	public int deleteMem(memberVO vo) throws Exception;
	
	// 리스트
	public List<memberVO> listMem() throws Exception;
	
}
