package com.soft.service;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.memberVO;

@Mapper
public interface AccountMapper {

	public int getIdCnt(memberVO searchVO);
	
	public void insertMember(memberVO searchVO);
}
