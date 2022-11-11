package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import com.soft.dao.ReplyDAO;
import com.soft.vo.replyVO;

public interface ReplyService {

	// ��� ���
	public List<replyVO> replyList(int board_no) throws Exception;
	
	// ��� �ۼ�
	public void replyWrite(replyVO vo) throws Exception;
	
	// ��� ����
	public void replyModify(replyVO vo) throws Exception;
	
	// ��� ����
	public void replyDelete(replyVO vo)throws Exception;
	
	// ��� ���� ���ε�
	public void boardReplyCount(int board_no) throws Exception;
}
