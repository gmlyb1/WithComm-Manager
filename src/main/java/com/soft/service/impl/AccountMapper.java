package com.soft.service.impl;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.memberVO;

@Mapper
public interface AccountMapper {

	 int getIdCnt(memberVO searchVO);
	 void insertMember(memberVO searchVO);
	 memberVO actionLogin(memberVO searchVO);
	 void updateLastLogin(memberVO searchVO);
}
