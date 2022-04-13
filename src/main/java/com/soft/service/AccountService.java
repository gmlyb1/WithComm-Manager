package com.soft.service;

import com.soft.vo.memberVO;

public interface AccountService {

	public int getIdCnt(memberVO searchVO);
	public void insertMember(memberVO searchVO);
}
