package com.soft.serviceInterFace;

import com.soft.vo.UserVO;

public interface UserService {

	int getIdCnt(UserVO searchVO);
	void insertMember(UserVO searchVO);
}
