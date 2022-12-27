package com.soft.dao;

import java.util.List;

import com.soft.vo.NoticeVO;


public interface NoticeDAO {

	// �������� �ۼ�
	public void insertNotice(NoticeVO vo) throws Exception;
	
	// �������� ���
	public List<NoticeVO> NoticeList() throws Exception;
	
	// �������� ��ȸ
	public NoticeVO NoticeRead(int notice_no) throws Exception;
	
	// �������� ����
	public void NoticeUpdate(NoticeVO vo) throws Exception;
	
	// �������� ����
	public void NoticeDelete(int notice_no) throws Exception;
	
	// �������� ��ȸ��
	public void NoticeHit(int notice_no) throws Exception;
}
