package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	//�Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	//�Խñ� ���
	public List<boardVO> BoardList() throws Exception;
	
	// �Խñ� ��ȸ
	public boardVO BoardRead(int board_no) throws Exception;
}
