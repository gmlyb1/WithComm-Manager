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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.BoardService;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Controller
public class BoardController {

	@Autowired
	@Inject
	private BoardService boardService;
	
	@Inject
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 목록
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public String BoardList(@ModelAttribute("vo") boardVO vo,HttpServletRequest request,Model model) throws Exception 
	{
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap) {
			model.addAttribute("msg", (String)inputFlashMap.get("msg"));
		}
		
		
		List<boardVO> boardList = boardService.BoardList(vo);
		
		model.addAttribute("boardList", boardList);
		
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
		
	try {
		SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
		
		Date time = new Date();
		
		String time1 = format1.format(time);
		vo.setBoard_regdate(time1);
		
		boardService.insertBoard(vo);
		
		
		redirect.addFlashAttribute("redirect", vo.getBoard_no());
		redirect.addFlashAttribute("msg", "등록이 완료되었습니다.");
		
	} catch (Exception e) {
			redirect.addFlashAttribute("msg", "오류가 발생되었습니다");
	}
		
		return "redirect:/board/list";
}

	// 게시글 조회
	@RequestMapping(value = "/board/read", method=RequestMethod.GET)
	public String BoardRead(boardVO vo, Model model) throws Exception {
		
		model.addAttribute("read", boardService.BoardRead(vo.getBoard_no()));
		
		List<replyVO> replyList = boardService.ReadReply(vo.getBoard_no());
		model.addAttribute("replyList", replyList);
		
		return "/board/read";
	}
	
	@RequestMapping(value = "/board/update" , method= RequestMethod.GET)
	public String BoardUpdateGET(boardVO vo, Model model) throws Exception
	{
		model.addAttribute("update", boardService.BoardRead(vo.getBoard_no()));
		return "/board/update";
	}
	
	//게시글 수정
	@RequestMapping(value = "/board/update", method= RequestMethod.POST)
	public String BoardUpdatePOST(boardVO vo,Model model,RedirectAttributes rttr) throws Exception
	{
		try {
			boardService.BoardUpdate(vo);
			rttr.addFlashAttribute("msg", "수정이 완료되었습니다.");
		}catch (Exception e) {
			rttr.addFlashAttribute("msg", "오류가 발생되었습니다.");
		}
		
		return "redirect:/board/list";
	}
	
	
	//게시글 삭제
	@RequestMapping(value = "/board/delete", method=RequestMethod.POST)
	public String BoardDeletePOST(boardVO vo, RedirectAttributes rttr) throws Exception
	{
		
		try {
		boardService.BoardDelete(vo.getBoard_no());
		rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		
		}catch(Exception e) {
		rttr.addFlashAttribute("msg", "오류가 발생되었습니다.");
		}
		
		
		return "redirect:/board/list";
	}
	
	// 게시글 등록 (GET)
		@RequestMapping(value = "/board/replyWrite", method= RequestMethod.GET)
		public void replyWrite() {
		}
	
	// 댓글작성
		@RequestMapping(value ="/board/replyWrite" , method= RequestMethod.POST)
		public String replyWrite(replyVO vo, RedirectAttributes rttr) throws Exception
		{
			try {
			
			boardService.replyWrite(vo);
			
			rttr.addFlashAttribute("board_no",vo.getBoard_no());
			rttr.addFlashAttribute("msg", "댓글작성을 완료하였습니다.");
			
			}catch (Exception e) {
			rttr.addFlashAttribute("msg", "댓글작성에 실패하였습니다.");
			}
			return "redirect:/board/read";
		}
	
	
	
	
	
	
	
	
}
