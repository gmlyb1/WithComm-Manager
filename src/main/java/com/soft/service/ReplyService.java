package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import com.soft.dao.ReplyDAO;
import com.soft.vo.replyVO;

public interface ReplyService {

	// ´ñ±Û ¸ñ·Ï
	public List<replyVO> replyList(int board_no) throws Exception;
	
	// ´ñ±Û ÀÛ¼º
	public void replyWrite(replyVO vo) throws Exception;
	
	// ´ñ±Û ¼öÁ¤
	public void replyModify(replyVO vo) throws Exception;
	
	// ´ñ±Û »èÁ¦
	public void replyDelete(replyVO vo)throws Exception;
}
