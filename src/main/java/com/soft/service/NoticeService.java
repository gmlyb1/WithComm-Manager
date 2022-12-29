package com.soft.service;

import java.util.List;

import com.soft.vo.NoticeVO;


public interface NoticeService {

	// ������
	public NoticeVO lastNoticeList(int notice_no) throws Exception;
		
	// ������
	public NoticeVO nextNoticeList(int notice_no) throws Exception;
	
	// �Խñ� �ۼ�
	public void insertNotice(NoticeVO vo) throws Exception;
	
	// �Խñ� ���
	public List<NoticeVO> NoticeList() throws Exception;
	
	// �Խñ� ��ȸ
	public NoticeVO NoticeRead(int notice_no) throws Exception;
	
	// �Խñ� ����
	public void NoticeUpdate(NoticeVO vo) throws Exception;
	
	// �Խñ� ����
	public void NoticeDelete(int notice_no) throws Exception;
	
	// �Խñ� ��ȸ��
	public void NoticeHit(int notice_no) throws Exception;
}
