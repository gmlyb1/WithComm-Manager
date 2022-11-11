package com.soft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardDAO {

	
	// 게시글 작성
	public void insertBoard(boardVO vo) throws Exception;
	
	// 첨부파일
	//public void insertFile(Map<String, Object>map) throws Exception;
	
	// 게시글 목록
	public List<boardVO> BoardList() throws Exception;

	// 메인에 뿌릴 글 목록
	public List<boardVO> HomeBoardList() throws Exception;
	
	// 게시글 조회
	public boardVO BoardRead(int board_no) throws Exception;
	
	// 게시글 수정
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// 게시글 삭제
	public void BoardDelete(int board_no) throws Exception;
	
	// 게시글 조회수
	public void BoardHit(int board_no) throws Exception;
	
	// 댓글 목록
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// 댓글 작성
	public void replyWrite(replyVO vo) throws Exception;

	// 활동 로그
	public void insertLog(LogVO logVO);
	
	// 댓글수
//	public void replyCount(int board_no,int amount) throws Exception;

	
	// boardLog
//	public Object memberInfo(String memberId);
//
//	public Object memberLog(String memberId);
//
//	public Object memberWrite(String memberId);
//
//	public Object memberScrap(String memberId);
//
//	public Object memberReply(String memberId);
	
}
