package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.BoardDAO;
import com.soft.dao.ReplyDAO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO replyDAO;

	// ´ñ±Û¸ñ·Ï
	@Override
	public List<replyVO> replyList(int board_no) throws Exception {
		return replyDAO.replyList(board_no);
	}

	// ´ñ±ÛÀÛ¼º
	@Override
	public void replyWrite(replyVO vo) throws Exception {
		replyDAO.replyWrite(vo);
	}
	
	// ´ñ±Û¼öÁ¤
	@Override
	public void replyModify(replyVO vo) throws Exception {
		replyDAO.replyModify(vo);
	}

	// ´ñ±Û»èÁ¦
	@Override
	public void replyDelete(int reply_no) throws Exception {
		replyDAO.replyDelete(reply_no);
	}

	@Override
	public void boardReplyCount(int board_no) throws Exception {
		replyDAO.boardReplyCount(board_no);
	}

}
