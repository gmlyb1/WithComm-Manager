package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	// �Խ��� ��� �޼���
	public List<boardVO> getList(boardVO searchVO);
	
	// �Խñ� ���� �޼���
	public void insertBoard(boardVO searchVO);
	
}
