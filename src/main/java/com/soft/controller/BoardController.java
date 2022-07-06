package com.soft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// 게시글 등록 (GET)
	@RequestMapping(value = "/board/create", method=RequestMethod.GET)
	public String BoardCreate(@ModelAttribute("searchVO") boardVO searchVO, Model model ) 
	{
		return "/board/create";
	}
	
	// 게시글 등록 (POST)
	@RequestMapping(value = "/board/create", method=RequestMethod.POST)
	public String create_action(@ModelAttribute("searchVO") boardVO searchVO, RedirectAttributes redirect)
	{
		SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
		
		Date time = new Date();
		
		String time1 = format1.format(time);
		//searchVO.setBoard_regdate(time1);
		
		//boardService.insertBoard(searchVO);
		
		//redirect.addFlashAttribute("redirect", searchVO.getBoard_idx());
		return "redirect:/board/list";
	}
	
	
	// 게시글 조회
	@RequestMapping(value = "/readView" , method = RequestMethod.GET)
	public String BoardRead(boardVO vo, Model model) throws Exception {
		
		model.addAttribute("BoardRead", boardService.BoardRead(vo.getBoard_no()));
		
		return "/board/readView";
	}
	
	
}
