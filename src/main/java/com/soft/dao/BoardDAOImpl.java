package com.soft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.BoardDAO";

	//글쓰기
	@Override
	public void insertBoard(boardVO vo) throws Exception {
			sqlSession.insert("namespace.insertBoard", vo);
	}
	
	//첨부파일
//	@Override
//	public void insertFile(Map<String, Object> map) throws Exception {
//			sqlSession.insert("namespace.insertFile",map);
//	}
	
	//글목록
	@Override
	public List<boardVO> BoardList() throws Exception {
		return sqlSession.selectList("namespace.BoardList");
	}
	
	@Override
	public List<boardVO> HomeBoardList() throws Exception {
		return sqlSession.selectList("namespace.HomeBoardList");
	}
	
	//글읽기
	@Override
	public boardVO BoardRead(int board_no) throws Exception {
		return sqlSession.selectOne("namespace.BoardRead", board_no);
	}
	
	// 게시글 수정
	@Override	
	public void BoardUpdate(boardVO vo) throws Exception {
		sqlSession.update("namespace.BoardUpdate",vo);
	}
	
	
	// 게시글 삭제
	@Override
	public void BoardDelete(int board_no) throws Exception {
		sqlSession.delete("namespace.BoardDelete",board_no);
	}

	@Override
	public void BoardHit(int board_no) throws Exception {
		sqlSession.update("namespace.BoardHit",board_no);
		
	}
	
	
	// 댓글 목록
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return sqlSession.selectList("namespace.ReadReply",board_no);
	}

	//댓글 작성
	@Override
	public void replyWrite(replyVO vo) throws Exception {
		sqlSession.insert("namespace.WriteReply", vo);
	}
	
	//활동로그
	@Override
	public void insertLog(LogVO logVO) {
		sqlSession.insert("namespace.insertLog",logVO);
	}

	

//	@Override
//	public void replyCount(int board_no, int amount) throws Exception {
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("board_no", board_no);
//		paramMap.put("amount", amount);
//		
//		sqlSession.update("namespace.replyCount",paramMap);
//	}

	/*
	 * @Override public Object memberInfo(String memberId) { return
	 * sqlSession.selectOne("namespace.memberInfo",memberId); }
	 * 
	 * @Override public Object memberLog(String memberId) { return
	 * sqlSession.selectOne("namespace.memberLog",memberId); }
	 * 
	 * @Override public Object memberWrite(String memberId) { return
	 * sqlSession.selectOne("namespace.memberWrite",memberId); }
	 * 
	 * @Override public Object memberScrap(String memberId) { return
	 * sqlSession.selectOne("namespace.memberScrap",memberId); }
	 * 
	 * @Override public Object memberReply(String memberId) { return
	 * sqlSession.selectOne("namespace.memberReply",memberId); }
	 */


	

}
