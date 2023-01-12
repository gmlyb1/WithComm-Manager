package com.soft.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardService {

	// 이전글
	public boardVO lastBoardList(int board_no) throws Exception;
	
	// 다음글
	public boardVO nextBoardList(int board_no) throws Exception;
	
	// 게시글 작성
	public void insertBoard(boardVO vo) throws Exception;
	
	// 게시글 목록
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	// 메인페이지 게시글 목록
	public List<boardVO> HomeBoardList(boardVO vo) throws Exception;
	
	// 게시글 조회
	public boardVO BoardRead(int board_no) throws Exception;
	
	// 게시글 수정
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// 게시글 삭제
	public void BoardDelete(int board_no) throws Exception;
	
	// 댓글 목록
	public List<replyVO> ReadReply(int board_no) throws Exception;

	// 댓글 작성
	public void replyWrite(replyVO vo) throws Exception;

	
}
