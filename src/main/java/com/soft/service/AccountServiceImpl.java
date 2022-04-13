package com.soft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.serviceInterFace.AccountService;
import com.soft.vo.memberVO;

@Service("AccountService")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountMapper mapper;
	
	@Override
	public int getIdCnt(memberVO searchVO) {
		return mapper.getIdCnt(searchVO);
	}

	@Override
	public void insertMember(memberVO searchVO) {
		mapper.insertMember(searchVO);
	}

}
