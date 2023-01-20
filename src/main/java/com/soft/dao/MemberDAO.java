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
	
	
	// ������ ����(��й�ȣ��)
	public void memberUpdate(String me_id) throws Exception;
	
	// ȸ�� ����
	public List<memberVO> memberManage(memberVO mVO)throws Exception;
	
	//ȸ�� Ż��(����)
	public void memberDelete(int me_id) throws Exception;
	
	// �̹��� ����
	public void updateImg(String memberImg, String me_id);
	
	// 관리자 지정
	public int selectManage(memberVO vo) throws Exception;
}
