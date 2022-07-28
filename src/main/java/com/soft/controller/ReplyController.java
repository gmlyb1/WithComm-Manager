package com.soft.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.ReplyService;
import com.soft.vo.replyVO;

@Controller
public class ReplyController {

	@Autowired
	@Inject
	private ReplyService replyService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@RequestMapping(value ="/replyWrite" , method= RequestMethod.GET)
	public String WriteReplyGET() throws Exception
	{
		return "redirect:/board/read";
	}
	
	
	// 댓글작성
	@RequestMapping(value ="/replyWrite" , method= RequestMethod.POST)
	public String WriteReplyPOST(replyVO vo, RedirectAttributes rttr) throws Exception
	{
		try {
		
		replyService.WriteReply(vo);
		
		rttr.addFlashAttribute("board_no",vo.getBoard_no());
		rttr.addFlashAttribute("msg", "댓글작성을 완료하였습니다.");
		
		}catch (Exception e) {
		rttr.addFlashAttribute("msg", "댓글작성에 실패하였습니다.");
		}
		return "redirect:/board/read";
	}
	
}
