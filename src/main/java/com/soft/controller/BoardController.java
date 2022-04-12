package com.soft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soft.vo.BoardVO;

@Controller
public class BoardController {
	
	
	@RequestMapping(value ="/board/list",method = RequestMethod.GET)
	public String BoardList(BoardVO vo) {
		return "/board/list";
	}
}
