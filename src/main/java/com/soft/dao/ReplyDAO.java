package com.soft.dao;

import java.util.List;

import com.soft.vo.replyVO;

public interface ReplyDAO {
	
	// ¥Ò±€ ∏Ò∑œ
	public List<replyVO> ReadReply(int board_no) throws Exception;
	
	// ¥Ò±€ ¿€º∫
	public void WriteReply(replyVO vo) throws Exception;
	
}
