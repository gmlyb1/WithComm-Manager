package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soft.vo.replyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.ReplyDAO";
	
	// ¥Ò±€ ∏Ò∑œ
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return sqlSession.selectList("ReplyDAO.ReadReply",board_no);
	}

	//¥Ò±€ ¿€º∫
	@Override
	public void WriteReply(replyVO vo) throws Exception {
		sqlSession.insert("namespace.WriteReply", vo);
	}

}
