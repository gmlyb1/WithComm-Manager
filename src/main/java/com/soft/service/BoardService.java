package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	// �Խ��� ��� �޼���
	List<boardVO> getList(boardVO searchVO);
	
	// �Խñ� ���� �޼���
	void insertBoard(boardVO searchVO);
	
}
