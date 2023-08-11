package com.soft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.BoardDAO";

	//�۾���
	@Override
	public void insertBoard(boardVO vo) throws Exception {
			sqlSession.insert("namespace.insertBoard", vo);
	}
	
	//÷������
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
			sqlSession.insert("namespace.insertFile",map);
	}
	
	//�۸��
	@Override
	public List<boardVO> BoardList() throws Exception {
		return sqlSession.selectList("namespace.BoardList");
	}
	
	@Override
	public List<boardVO> HomeBoardList() throws Exception {
		return sqlSession.selectList("namespace.HomeBoardList");
	}
	
	//���б�
	@Override
	public boardVO BoardRead(int board_no) throws Exception {
		return sqlSession.selectOne("namespace.BoardRead", board_no);
	}
	
	// �Խñ� ����
	@Override	
	public void BoardUpdate(boardVO vo) throws Exception {
		sqlSession.update("namespace.BoardUpdate",vo);
	}
	
	
	// �Խñ� ����
	@Override
	public void BoardDelete(int board_no) throws Exception {
		sqlSession.delete("namespace.BoardDelete",board_no);
	}

	@Override
	public void BoardHit(int board_no) throws Exception {
		sqlSession.update("namespace.BoardHit",board_no);
		
	}
	
	
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return sqlSession.selectList("namespace.ReadReply",board_no);
	}

	@Override
	public void replyWrite(replyVO vo) throws Exception {
		sqlSession.insert("namespace.WriteReply", vo);
	}

	@Override
	public boardVO lastBoardList(int board_no) throws Exception {
		
		return sqlSession.selectOne("namespace.lastBoardList", board_no);
	}

	@Override
	public boardVO nextBoardList(int board_no) throws Exception {
		
		return sqlSession.selectOne("namespace.nextBoardList", board_no);
	}

	@Override
	public boardVO boardCnt(boardVO vo) throws Exception {
		return sqlSession.selectOne("namespace.boardCnt",vo);
	}

	@Override
	public int boardCntForPaging(boardVO vo) throws Exception {
		return sqlSession.selectOne("namespace.boardCntForPaging",vo);
	}




	

}
