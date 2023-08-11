package com.soft.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardService {

	public boardVO lastBoardList(int board_no) throws Exception;
	
	public boardVO nextBoardList(int board_no) throws Exception;
	
	public void insertBoard(boardVO vo) throws Exception;
	
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	public List<boardVO> HomeBoardList(boardVO vo) throws Exception;
	
	public boardVO BoardRead(int board_no) throws Exception;
	
	public void BoardUpdate(boardVO vo) throws Exception;
	
	public void BoardDelete(int board_no) throws Exception;
	
	public List<replyVO> ReadReply(int board_no) throws Exception;

	public void replyWrite(replyVO vo) throws Exception;

	public boardVO boardCnt(boardVO vo) throws Exception;
	
	public int boardCntForPaging(boardVO vo) throws Exception;
}
