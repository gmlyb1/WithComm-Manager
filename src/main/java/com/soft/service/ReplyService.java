package com.soft.service;

import java.util.List;

import com.soft.vo.replyVO;

public interface ReplyService {

	// ��� ���
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// ��� �ۼ�
	public void WriteReply(replyVO vo) throws Exception;
}
