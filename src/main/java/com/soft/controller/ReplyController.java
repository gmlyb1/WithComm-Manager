package com.soft.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.service.ReplyService;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	
	// ��� ��ȸ
	
	
	// ��� �ۼ�
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String postWrite(replyVO vo,boardVO bvo) throws Exception {
		
		 replyService.replyWrite(vo);
		
		return "redirect:/board/read?board_no="+bvo.getBoard_no();
	}
	// ��� ����
	
	// ��� ����
}
