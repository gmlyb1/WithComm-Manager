package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

public interface ReplyDAO {
	
	// 댓글 목록
	public List<replyVO> replyList(int board_no) throws Exception;
	
	// 댓글 작성
	public void replyWrite(replyVO vo) throws Exception;
	
	// 댓글 수정
	public void replyModify(replyVO vo) throws Exception;
	
	// 댓글 삭제
	public void replyDelete(int reply_no)throws Exception;
	
	// 댓글개수 바인딩
	public void boardReplyCount(int board_no) throws Exception;

}
