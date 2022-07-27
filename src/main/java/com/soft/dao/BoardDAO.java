package com.soft.dao;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.soft.vo.boardVO;

public interface BoardDAO {

	
	// �Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	// �Խñ� ���
	public List<boardVO> BoardList() throws Exception;
	
	// �Խñ� ��ȸ
	public boardVO BoardRead(int board_no) throws Exception;
	
	// �Խñ� ����
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// �Խñ� ����
	public void BoardDelete(int board_no) throws Exception;
}
