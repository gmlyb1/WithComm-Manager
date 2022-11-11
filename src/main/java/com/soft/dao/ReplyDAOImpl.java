package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.replyVO;

public class ReplyDAOImpl implements ReplyDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.soft.dao.ReplyDAO";

	// ´ñ±Û ¸ñ·Ï
	@Override
	public List<replyVO> replyList(int board_no) throws Exception {
		return sqlSession.selectList("namespace.replyList", board_no);
	}

	// ´ñ±Û ÀÛ¼º
	@Override
	public void replyWrite(replyVO vo) throws Exception {
		sqlSession.selectOne("namespace.replyWrite", vo);
	}
	
	// ´ñ±Û ¼öÁ¤
	@Override
	public void replyModify(replyVO vo) throws Exception {
		sqlSession.update("namespace.replyModify", vo);
	}

	// ´ñ±Û »èÁ¦
	@Override
	public void replyDelete(replyVO vo) throws Exception {
		sqlSession.delete("namespace.replyDelete", vo);
	}

	@Override
	public void boardReplyCount(int board_no) throws Exception {
		sqlSession.selectOne("namespace.boardReplyCount", board_no);
	}

	
	
	
}
