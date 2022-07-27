package com.soft.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.soft.vo.boardVO;

public interface BoardDAO {

	
	// 게시글 작성
	public void insertBoard(boardVO vo) throws Exception;
	
	// 게시글 목록
	public List<boardVO> BoardList() throws Exception;
	
	// 게시글 조회
	public boardVO BoardRead(int board_no) throws Exception;
	
	// 게시글 수정
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// 게시글 삭제
	public void BoardDelete(int board_no) throws Exception;
}
