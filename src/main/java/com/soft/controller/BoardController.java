package com.soft.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.service.BoardService;
import com.soft.vo.boardVO;

@Controller
public class BoardController {

	
	@Inject
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 목록
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public String BoardList(Model model) throws Exception {
		
		model.addAttribute("BoardList", boardService.BoardList());
		
		return "/board/list";
	}
	
	// 게시글 조회
	@RequestMapping(value = "/readView" , method = RequestMethod.GET)
	public String BoardRead(boardVO vo, Model model) throws Exception {
		
		model.addAttribute("BoardRead", boardService.BoardRead(vo.getBoard_no()));
		
		return "/board/readView";
	}
	
	
}
