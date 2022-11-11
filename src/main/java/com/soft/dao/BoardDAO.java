package com.soft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardDAO {

	
	// �Խñ� �ۼ�
	public void insertBoard(boardVO vo) throws Exception;
	
	// ÷������
	//public void insertFile(Map<String, Object>map) throws Exception;
	
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

	// Ȱ�� �α�
	public void insertLog(LogVO logVO);
	
	// ��ۼ�
//	public void replyCount(int board_no,int amount) throws Exception;

	
	// boardLog
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
