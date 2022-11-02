package com.soft.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.service.ReplyService;
import com.soft.vo.replyVO;

@Controller
public class ReplyController {

	@Inject
	private ReplyService replyService;
	
	// ¥Ò±€ ¡∂»∏
	
	
	// ¥Ò±€ ¿€º∫
	@RequestMapping(value = "/reply/write", method=RequestMethod.POST)
	public String postWrite(replyVO vo) throws Exception {
		
		 replyService.replyWrite(vo);
		
		return "redirect:/board/read?board_no="+vo.getBoard_no();
	}
	// ¥Ò±€ ºˆ¡§
	
	// ¥Ò±€ ªË¡¶
}
