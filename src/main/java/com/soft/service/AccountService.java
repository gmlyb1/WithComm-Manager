package com.soft.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.vo.memberVO;


public interface AccountService {

	// �ߺ�Ȯ��
	public int checkMemId(int me_id) throws Exception;
	
	// ȸ������
	public void memJoin(memberVO vo) throws Exception;
	
	// �α���
	public List loginMem(memberVO vo) throws Exception;
	
	// ȸ������
	public memberVO memInfo(int me_id)throws Exception;
	
	// ȸ������
	public int memUpdate(memberVO vo) throws Exception;
	
	// ȸ��Ż��
	public int memDelete(memberVO vo) throws Exception;
	
	// ���� ����Ʈ
	public List<memberVO> memList() throws Exception;
	
	
	
	
}
