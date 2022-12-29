package com.soft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardDAO {

	// ������
	public boardVO lastBoardList(int board_no) throws Exception;
	
	// ������
	public boardVO nextBoardList(int board_no) throws Exception;
	
	// �Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	// ÷������
	public void insertFile(Map<String, Object> map) throws Exception;
	
	// �Խñ� ���
	public List<boardVO> BoardList() throws Exception;

	// ���ο� �Ѹ� �� ���
	public List<boardVO> HomeBoardList() throws Exception;
	
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
