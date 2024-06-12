package com.soft.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.soft.service.ReplyService;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String postWrite(replyVO vo,boardVO bvo) throws Exception {
		
		 replyService.replyWrite(vo);
		
//		 System.out.println("result Param :" + bvo.getBoard_no() );
		 
		return "redirect:/board/read?board_no="+bvo.getBoard_no();
	}
	@RequestMapping(value="/delete" , method=RequestMethod.GET)
	public String removeReply(@RequestParam("reply_no")int reply_no, @RequestParam("board_no")int board_no, boardVO bvo, replyVO rvo) throws Exception 
	{
		
		replyService.replyDelete(reply_no);
		
		return "redirect:/board/read?board_no="+bvo.getBoard_no();
	}
}
