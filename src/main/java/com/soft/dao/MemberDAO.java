package com.soft.dao;

import java.util.List;


import com.soft.vo.memberVO;

public interface MemberDAO {


	// ȸ������
	public void register(memberVO vo) throws Exception;
	
	// �α���
	public memberVO login(memberVO vo) throws Exception;
	
	// ��й�ȣ üũ
	public int passChk(memberVO vo) throws Exception;

	// ���̵� �ߺ� üũ
	public int idChk(memberVO vo) throws Exception;
	
	// ������
	public memberVO memberInfoSearch(memberVO mVO)throws Exception;
	
	// ������ ����
	public void memberUpdate(memberVO mVO) throws Exception;
	
	// ȸ�� ����
	public List<memberVO> memberManage(memberVO mVO)throws Exception;
	
	//ȸ�� Ż��(����)
	public void memberDelete(int me_id) throws Exception;
}
