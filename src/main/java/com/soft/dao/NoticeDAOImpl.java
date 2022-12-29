package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.NoticeVO;
import com.soft.vo.boardVO;


public class NoticeDAOImpl implements NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.NoticeDAO";

	@Override
	public void insertNotice(NoticeVO vo) throws Exception {
		sqlSession.insert("namespace.insertNotice", vo);
	}

	@Override
	public List<NoticeVO> NoticeList() throws Exception {
		return sqlSession.selectList("namespace.NoticeList");
	}

	@Override
	public NoticeVO NoticeRead(int notice_no) throws Exception {
		return sqlSession.selectOne("namespace.NoticeRead", notice_no);
	}

	@Override
	public void NoticeUpdate(NoticeVO vo) throws Exception {
		sqlSession.update("namespace.NoticeUpdate",vo);
	}

	@Override
	public void NoticeDelete(int notice_no) throws Exception {
		sqlSession.delete("namespace.NoticeDelete",notice_no);
	}

	@Override
	public void NoticeHit(int notice_no) throws Exception {
		sqlSession.update("namespace.NoticeHit", notice_no);
			
	}

	@Override
	public NoticeVO lastNoticeList(int notice_no) throws Exception {
		
		return sqlSession.selectOne("namespace.lastBoardList", notice_no);
	}

	@Override
	public NoticeVO nextNoticeList(int notice_no) throws Exception {
		
		return sqlSession.selectOne("namespace.nextBoardList", notice_no);
	}

	
	

}
