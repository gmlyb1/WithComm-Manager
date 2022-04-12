package com.soft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.serviceInterFace.UserService;
import com.soft.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public int getIdCnt(UserVO searchVO) {
		return mapper.getIdCnt(searchVO);
	}

	@Override
	public void insertMember(UserVO searchVO) {
		mapper.insertMember(searchVO);
	}

}
