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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.BoardService;
//import com.soft.service.BoardMapper;
//import com.soft.service.BoardService;
import com.soft.vo.boardVO;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value ="/board/list",method = RequestMethod.GET)
	public String list(@ModelAttribute("searchVO") boardVO searchVO, HttpServletRequest request,Model model) {
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		if(null != inputFlashMap) {
			model.addAttribute("msg", (String) inputFlashMap.get("msg"));
		}
		  List<boardVO> boardList = boardService.getList(searchVO);
		  model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	@RequestMapping(value= "/board/create", method= RequestMethod.GET)
	public String create(@ModelAttribute("searchVO") boardVO searchVO, Model model) {

		return "/board/create";
	}
	
	@RequestMapping(value="/board/create_action",method= RequestMethod.POST)
	public String create_action(@ModelAttribute("searchVO") boardVO searchVO, HttpServletRequest request, RedirectAttributes redirect) {
	try {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		
		String time1 = format1.format(time);
		searchVO.setBoard_regdate(time1);
		
		boardService.getList(searchVO);
		
		redirect.addFlashAttribute("redirect", searchVO.getBoard_idx());
		redirect.addFlashAttribute("msg", "등록이 완료되었습니다.");
	} catch (Exception e) {
		redirect.addFlashAttribute("msg", "등록에 실패하였습니다.");
	}	
		
		return "redirect:/board/list";
	}
	
	
}
