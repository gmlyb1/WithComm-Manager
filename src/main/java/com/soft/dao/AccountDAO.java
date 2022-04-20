package com.soft.dao;

import java.util.List;

import com.soft.vo.memberVO;

public interface AccountDAO {

	// �ߺ�üũ
	public int checkMemId(int me_id) throws Exception;
	
	// ȸ������
	public void joinMem(memberVO vo) throws Exception;
	
	// �α���
	public List loginMem(memberVO vo) throws Exception;
	
	// ����
	public memberVO infoMem(int me_id) throws Exception;
	
	// ����
	public int updateMem(memberVO vo) throws Exception;
	
	// Ż��
	public int deleteMem(memberVO vo) throws Exception;
	
	// ����Ʈ
	public List<memberVO> listMem() throws Exception;
	
}
