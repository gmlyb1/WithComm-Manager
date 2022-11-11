package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import com.soft.dao.ReplyDAO;
import com.soft.vo.replyVO;

public interface ReplyService {

	// 댓글 목록
	public List<replyVO> replyList(int board_no) throws Exception;
	
	// 댓글 작성
	public void replyWrite(replyVO vo) throws Exception;
	
	// 댓글 수정
	public void replyModify(replyVO vo) throws Exception;
	
	// 댓글 삭제
	public void replyDelete(replyVO vo)throws Exception;
	
	// 댓글 개수 바인딩
	public void boardReplyCount(int board_no) throws Exception;
}
