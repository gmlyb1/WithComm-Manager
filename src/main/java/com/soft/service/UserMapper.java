package com.soft.service;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.UserVO;

@Mapper
public interface UserMapper {

	int getIdCnt(UserVO searchVO);
	
	void insertMember(UserVO searchVO);
}
