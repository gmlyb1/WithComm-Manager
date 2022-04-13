package com.soft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.service.BoardMapper;
import com.soft.service.BoardService;
//import com.soft.service.BoardMapper;
//import com.soft.service.BoardService;
import com.soft.vo.boardVO;

@Controller
public class BoardController {
	
	
	  @Autowired
	  private BoardService boardService;
	 
	  @Autowired 
	  private BoardMapper boardMapper;
	
	
	@RequestMapping(value ="/board/list",method = RequestMethod.GET)
	public String BoardLists(@ModelAttribute("searchVO") boardVO searchVO, Model model) {
		
		
		  List<boardVO> boardList = boardService.getBoardList(searchVO);
		  model.addAttribute("boardList", boardList);
		 
		
		return "/board/list";
	}
}
