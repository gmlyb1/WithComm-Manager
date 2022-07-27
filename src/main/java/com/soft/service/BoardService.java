package com.soft.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	//게시글 작성
	public void insertBoard(boardVO vo) throws Exception;
	
	//게시글 목록
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	//글읽기
	public boardVO BoardRead(int board_no) throws Exception;
	
	// 게시글 수정
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// 게시글 삭제
	public void BoardDelete(int board_no) throws Exception;
}
