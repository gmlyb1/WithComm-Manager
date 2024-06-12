package com.soft.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.soft.service.NoticeService;
import com.soft.vo.NoticeVO;


@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String NoticeList(@ModelAttribute("vo")NoticeVO vo,HttpServletRequest request,Model model) throws Exception {
		
		Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
		
		if(null != inputFlashMap) {
			model.addAttribute("msg", (String)inputFlashMap.get("msg"));
		}
		
		List<NoticeVO> noticeList = noticeService.NoticeList();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("FixedList", noticeService.selectNoticeImportant(vo));
		
		return "/notice/list";
	}
	
			@RequestMapping(value = "/create", method= RequestMethod.GET)
			public void insertNoticeGET() {
			}
			
			// 글쓰기 (POST)
			@RequestMapping(value= "/create" , method = RequestMethod.POST)
			public String insertNoticePOST(@ModelAttribute("vo") NoticeVO vo,HttpServletRequest request ,RedirectAttributes redirect) throws Exception 
			{
				
			try {
//				SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
//				
//				Date time = new Date();
//				
//				String time1 = format1.format(time);
//				vo.setNotice_regdate(time1);
				
				noticeService.insertNotice(vo);
				
				redirect.addFlashAttribute("redirect", vo.getNotice_no());
				redirect.addFlashAttribute("msg", "글 작성을 완료하였습니다.");
				
			} catch (Exception e) {
					redirect.addFlashAttribute("msg", "오류가 발생하였습니다." + e);
			}
				
				return "redirect:/notice/list";
		}
			
			@RequestMapping(value = "/read", method=RequestMethod.GET)
			public String NoticeRead(@RequestParam("notice_no") int notice_no,NoticeVO vo, Model model) throws Exception {
				
				model.addAttribute("read", noticeService.NoticeRead(vo.getNotice_no()));
				model.addAttribute("lastNoticeList", noticeService.lastNoticeList(notice_no));
				model.addAttribute("nextNoticeList", noticeService.nextNoticeList(notice_no));
				
				
				return "/notice/read";
			}
			
			
			@RequestMapping(value = "/update" , method= RequestMethod.GET)
			public String NoticeUpdateGET(NoticeVO vo, Model model) throws Exception
			{
				model.addAttribute("update", noticeService.NoticeRead(vo.getNotice_no()));
//				List<Map<String, Object>> fileList = boardService.selectFileList(vo.getBoard_no());
//				model.addAttribute("file", fileList);
				
				
				return "/notice/update";
			}
			
			@RequestMapping(value = "/update", method= RequestMethod.POST)
			public String NoticeUpdatePOST(NoticeVO vo,Model model,RedirectAttributes rttr) throws Exception
			{
				try {
					noticeService.NoticeUpdate(vo);
					rttr.addFlashAttribute("msg", "글 수정을 완료하였습니다.");
				}catch (Exception e) {
					rttr.addFlashAttribute("msg", "오류가 발생하였습니다." + e);
				}
				
				return "redirect:/notice/list";
			}
			
			@RequestMapping(value = "/delete", method=RequestMethod.POST)
			public String NoticeDeletePOST(NoticeVO vo, RedirectAttributes rttr) throws Exception
			{
				
				try {
					noticeService.NoticeDelete(vo.getNotice_no());
				rttr.addFlashAttribute("msg", "삭제를 완료하였습니다.");
				
				}catch(Exception e) {
				rttr.addFlashAttribute("msg", "오류가 발생하였습니다." + e);
				}
				
				
				return "redirect:/notice/list";
			}
			
}
