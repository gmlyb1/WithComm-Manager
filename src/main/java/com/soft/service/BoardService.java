package com.soft.service;

import java.util.List;


import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardService {

	// �Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	// �Խñ� ���
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	// ���������� �Խñ� ���
	public List<boardVO> HomeBoardList(boardVO vo) throws Exception;
	
	// �Խñ� ��ȸ
	public boardVO BoardRead(int board_no) throws Exception;
	
	// �Խñ� ����
	public void BoardUpdate(boardVO vo) throws Exception;
	
	// �Խñ� ����
	public void BoardDelete(int board_no) throws Exception;
	
	// ��� ���
	public List<replyVO> ReadReply(int board_no) throws Exception;

	// ��� �ۼ�
	public void replyWrite(replyVO vo) throws Exception;

	//��ۼ�
//	public void replyCount(int board_no,int amount) throws Exception;
	
	
	
	// board log
//	public Object memberInfo(String memberId);
//
//	public Object memberLog(String memberId);
//
//	public Object memberWrite(String memberId);
//
//	public Object memberScrap(String memberId);
//
//	public Object memberReply(String memberId);
	
}
