package com.soft.dao;

import java.util.List;


import com.soft.vo.memberVO;

public interface MemberDAO {


	// 회원가입
	public void register(memberVO vo) throws Exception;
	
	// 로그인
	public memberVO login(memberVO vo) throws Exception;
}
