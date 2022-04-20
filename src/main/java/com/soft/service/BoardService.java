package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	// 게시판 목록 메서드
	public List<boardVO> getList(boardVO searchVO);
	
	// 게시글 쓰기 메서드
	public void insertBoard(boardVO searchVO);
	
}
