package com.soft.dao;

import java.util.List;

import com.soft.vo.replyVO;

public interface ReplyDAO {
	
	// ��� ���
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// ��� �ۼ�
	public void WriteReply(replyVO vo) throws Exception;
	
}
