package com.soft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.BoardService;
import com.soft.vo.boardVO;

@Controller
public class BoardController {

	@Autowired
	@Inject
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 목록
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public String BoardList(@ModelAttribute("searchVO") boardVO searchVO,HttpServletRequest request,Model model) throws Exception 
	{
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap) {
			model.addAttribute("msg", (String)inputFlashMap.get("msg"));
		}
		
		List<boardVO> boardList = boardService.BoardList();
		
		model.addAttribute("BoardList", boardService.BoardList());
		
		return "/board/list";
	}
	
	// 게시글 등록 (GET)
	@RequestMapping(value = "/board/create", method= RequestMethod.GET)
	public void insertBoardGET() {
	}
	
	// 게시글 등록 (POST)
	@RequestMapping(value= "/board/create" , method = RequestMethod.POST)
	public String insertBoardPOST(@ModelAttribute("vo") boardVO vo,HttpServletRequest request ,RedirectAttributes redirect) throws Exception
	{
		SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
		
		Date time = new Date();
		
		String time1 = format1.format(time);
		vo.setBoard_regdate(time1);
		
		boardService.insertBoard(vo);
	
		return "redirect:/board/list";
}

	
	// 게시글 조회
	/*
	 * @RequestMapping(value = "/readView" , method = RequestMethod.GET) public
	 * String BoardRead(boardVO vo, Model model) throws Exception {
	 * 
	 * model.addAttribute("BoardRead", boardService.BoardRead(vo.getBoard_no());
	 * 
	 * return "/board/readView"; }
	 */
	
	
}
