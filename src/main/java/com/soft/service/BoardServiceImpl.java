package com.soft.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.dao.BoardDAO;
import com.soft.util.FileUtils;
import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Inject
	private FileUtils fileUtils;

	// 게시글 작성
	@Override
	public void insertBoard(boardVO vo) throws Exception {
		boardDAO.insertBoard(vo);
		
		// 활동로그
//		LogVO logVO = new LogVO();
//		logVO.setBno(vo.getBoard_no());
//		logVO.setMemberId(vo.getBoard_writer());
//		logVO.setCategori(1);
//		boardDAO.insertLog(logVO);
	}

	// 게시글 목록
	@Override
	public List<boardVO> BoardList(boardVO vo) throws Exception {
		return boardDAO.BoardList();
	}

	// 게시글 조회+조회수
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public boardVO BoardRead(int board_no) throws Exception {
			   boardDAO.BoardHit(board_no);
		return boardDAO.BoardRead(board_no);
	}
	
	// 댓글 작성
	@Transactional
	@Override
	public void replyWrite(replyVO vo) throws Exception {
		boardDAO.replyWrite(vo);
		
//		boardDAO.replyCount(vo.getBoard_no(), 1);
	}

	
	// 게시글 수정
	@Override
	public void BoardUpdate(boardVO vo) throws Exception {
		boardDAO.BoardUpdate(vo);
	}

	// 게시글 삭제
	@Override
	public void BoardDelete(int board_no) throws Exception {
		boardDAO.BoardDelete(board_no);
		
	}

	// 댓글 목록
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return boardDAO.ReadReply(board_no);
	}
	

//	@Transactional(isolation =  Isolation.READ_COMMITTED)
//	@Override
//	public void replyCount(int amount,int board_no) throws Exception {
//		boardDAO.replyCount(amount,board_no);
//		
//	}

//	@Override
//	public Object memberInfo(String memberId) {
//		return boardDAO.memberInfo(memberId);
//	}
//
//	@Override
//	public Object memberLog(String memberId) {
//		return boardDAO.memberLog(memberId);
//	}
//
//	@Override
//	public Object memberWrite(String memberId) {
//		return boardDAO.memberWrite(memberId);
//	}
//
//	@Override
//	public Object memberScrap(String memberId) {
//		return boardDAO.memberScrap(memberId);
//	}
//
//	@Override
//	public Object memberReply(String memberId) {
//		return boardDAO.memberReply(memberId);
//	}

}
