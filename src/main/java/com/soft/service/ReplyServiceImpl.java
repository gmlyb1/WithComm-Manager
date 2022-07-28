package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.ReplyDAO;
import com.soft.vo.replyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO replyDAO;

	// ��� ���
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return replyDAO.ReadReply(board_no);
	}
	
	// ��� �ۼ�
	@Override
	public void WriteReply(replyVO vo) throws Exception {
		replyDAO.WriteReply(vo);
	}
	
	
}
