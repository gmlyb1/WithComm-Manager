package com.soft.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	//�Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	//�Խñ� ���
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	//���б�
	public boardVO BoardRead(int board_no) throws Exception;
	
	// �Խñ� ����
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// �Խñ� ����
	public void BoardDelete(int board_no) throws Exception;
}
