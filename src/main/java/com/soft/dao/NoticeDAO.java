package com.soft.dao;

import java.util.List;

import com.soft.vo.NoticeVO;


public interface NoticeDAO {

	public NoticeVO lastNoticeList(int notice_no) throws Exception;
		
	public NoticeVO nextNoticeList(int notice_no) throws Exception;
	
	public void insertNotice(NoticeVO vo) throws Exception;
	
	public List<NoticeVO> NoticeList() throws Exception;
	
	public NoticeVO NoticeRead(int notice_no) throws Exception;
	
	public void NoticeUpdate(NoticeVO vo) throws Exception;
	
	public void NoticeDelete(int notice_no) throws Exception;
	
	public void NoticeHit(int notice_no) throws Exception;
	
	public List<NoticeVO> HomeNoticeList() throws Exception;
	
	public List<NoticeVO> selectNoticeImportant(NoticeVO vo) throws Exception;
}
