package com.soft.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface BoardService {

	// �Խñ� �ۼ�
	public void insertBoard(boardVO vo,MultipartHttpServletRequest mpRequest) throws Exception;
	
	// �Խñ� ���
	public List<boardVO> BoardList(boardVO vo) throws Exception;
	
	// ���������� �Խñ� ���
	public List<boardVO> HomeBoardList(boardVO vo) throws Exception;
	
	// �Խñ� ��ȸ
	public boardVO BoardRead(int board_no) throws Exception;
	
	// �Խñ� ����
	public void BoardUpdate(boardVO vo,String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;
	
	// �Խñ� ����
	public void BoardDelete(int board_no) throws Exception;
	
	// ��� ���
	public List<replyVO> ReadReply(int board_no) throws Exception;

	// ��� �ۼ�
	public void replyWrite(replyVO vo) throws Exception;

	//��ۼ�
//	public void replyCount(int board_no,int amount) throws Exception;
	
	// ������,������
	public boardVO movePage(int board_no) throws Exception;
	
	// ÷������ ��ȸ
//	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	
	// ÷������ �ٿ�ε�
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;

	// ÷������ ����
//	public void updateFile(Map<String, Object> map) throws Exception;
}
