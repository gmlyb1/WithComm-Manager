package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardDAO {

	
	// 게시글 작성
	public void BoardWrite(boardVO vo) throws Exception;
	
	// 게시글 목록 조회
	public List<boardVO> BoardList() throws Exception;
	
	// 게시물 조회
	public boardVO BoardRead(int board_no) throws Exception;

}
