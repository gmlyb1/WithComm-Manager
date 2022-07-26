package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	//게시글 작성
	public void insertBoard(boardVO vo) throws Exception;
	
	//게시글 목록
	public List<boardVO> BoardList() throws Exception;
	
	// 게시글 조회
	public boardVO BoardRead(int board_no) throws Exception;
}
