package com.soft.serviceInterFace;

import com.soft.vo.memberVO;

public interface AccountService {

	int getIdCnt(memberVO searchVO);
	void insertMember(memberVO searchVO);
}
