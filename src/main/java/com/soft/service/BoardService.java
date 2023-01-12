package com.soft.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardService {

	// ������
	public boardVO lastBoardList(int board_no) throws Exception;
	
	// ������
	public boardVO nextBoardList(int board_no) throws Exception;
	
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

	
}
