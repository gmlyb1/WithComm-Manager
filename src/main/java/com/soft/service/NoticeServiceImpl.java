package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.soft.dao.NoticeDAO;
import com.soft.vo.NoticeVO;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDAO noticeDAO;

	@Override
	public void insertNotice(NoticeVO vo) throws Exception {
		noticeDAO.insertNotice(vo);
	}

	@Override
	public List<NoticeVO> NoticeList() throws Exception {
		return noticeDAO.NoticeList();
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public NoticeVO NoticeRead(int notice_no) throws Exception {
		noticeDAO.NoticeHit(notice_no);
		return noticeDAO.NoticeRead(notice_no);
	}

	@Override
	public void NoticeUpdate(NoticeVO vo) throws Exception {
		noticeDAO.NoticeUpdate(vo);
	}

	@Override
	public void NoticeDelete(int notice_no) throws Exception {
		noticeDAO.NoticeDelete(notice_no);
	}

	@Override
	public void NoticeHit(int notice_no) throws Exception {
		noticeDAO.NoticeHit(notice_no);
	}

	@Override
	public NoticeVO lastNoticeList(int notice_no) throws Exception {
		return noticeDAO.lastNoticeList(notice_no);
	}

	@Override
	public NoticeVO nextNoticeList(int notice_no) throws Exception {
		return noticeDAO.nextNoticeList(notice_no);
	}

	

}
