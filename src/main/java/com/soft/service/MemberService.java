package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface MemberService {

	// ȸ������
	public void register(memberVO vo) throws Exception;
	
	// �α���
	public memberVO login(memberVO vo) throws Exception;
	
	
}
