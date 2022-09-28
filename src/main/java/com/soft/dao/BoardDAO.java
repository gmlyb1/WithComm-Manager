package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

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
	
	// �Խñ� ��ȸ��
	public void BoardHit(int board_no) throws Exception;
	
	// ��� ���
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// ��� �ۼ�
	public void replyWrite(replyVO vo) throws Exception;
}
