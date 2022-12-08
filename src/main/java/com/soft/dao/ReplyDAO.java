package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface ReplyDAO {
	
	// ��� ���
	public List<replyVO> replyList(int board_no) throws Exception;
	
	// ��� �ۼ�
	public void replyWrite(replyVO vo) throws Exception;
	
	// ��� ����
	public void replyModify(replyVO vo) throws Exception;
	
	// ��� ����
	public void replyDelete(int reply_no)throws Exception;
	
	// ��۰��� ���ε�
	public void boardReplyCount(int board_no) throws Exception;

}
