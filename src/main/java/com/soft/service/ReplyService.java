package com.soft.service;

import java.util.List;

import com.soft.vo.replyVO;

public interface ReplyService {

	// ¥Ò±€ ∏Ò∑œ
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// ¥Ò±€ ¿€º∫
	public void WriteReply(replyVO vo) throws Exception;
}
