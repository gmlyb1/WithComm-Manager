package com.soft.service;

import com.soft.vo.memberVO;

public interface AccountService {

	 int getIdCnt(memberVO searchVO);
	 void insertMember(memberVO searchVO);
	 memberVO actionLogin(memberVO searchVO);
	 void updateLastLogin(memberVO searchVO);
}
