package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardDAO {

	
	// �Խñ� �ۼ�
	public void BoardWrite(boardVO vo) throws Exception;
	
	// �Խñ� ��� ��ȸ
	public List<boardVO> BoardList() throws Exception;
	
	// �Խù� ��ȸ
	public boardVO BoardRead(int board_no) throws Exception;

}
