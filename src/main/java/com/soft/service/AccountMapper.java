package com.soft.service;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.memberVO;

@Mapper
public interface AccountMapper {

	int getIdCnt(memberVO searchVO);
	
	void insertMember(memberVO searchVO);
}
