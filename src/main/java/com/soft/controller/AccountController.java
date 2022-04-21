package com.soft.controller;

import java.io.File;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soft.service.AccountService;
import com.soft.vo.memberVO;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AccountController {

	@Inject
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	// 로그아웃 
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpSession session, HttpServletResponse response) throws Exception {
		
		session.invalidate();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<script>alert('로그아웃 되었습니다.'); location.href='/account/login';</script>");
		out.flush();
	}
	
	// 로그인 
	@RequestMapping(value ="/account/login" , method=RequestMethod.GET)
	public String login() throws Exception{
		
		return "/account/login";
		
	}
	
	
	// 로그인 액션
	@RequestMapping(value = "/account/login" , method=RequestMethod.POST)
	public String loginAction(memberVO vo, HttpSession session, Model model) throws Exception {

		List loginList = accountService.loginMem(vo);
		memberVO resultVO = (memberVO) loginList.get(0);
		int result = (int)loginList.get(1);
		
		session.setAttribute("result", result);
		
		if(resultVO != null) {
			session.setAttribute("resultVO", resultVO);
			session.setAttribute("me_id", resultVO.getMe_id());
		}
		return "redirect:/home";
	}
	
	// 회원정보
	@RequestMapping(value= "/infoMem" , method=RequestMethod.GET)
	public String mem_infoGET(HttpSession session) throws Exception{
		
		int me_id = (int)session.getAttribute("me_id");
		
		memberVO resultVO = accountService.memInfo(me_id);
		
		session.setAttribute("resultVO", resultVO);
		
		return "/account/infoMem";
	}
	
	
	// 회원정보 수정(GET)
	@RequestMapping(value = "/updateMem1", method=RequestMethod.POST)
	public String mem_update() throws Exception {
		
		logger.info("UPDATEGET 실행");
		
		return "redirect:/updateMem";
	}

	// 회원정보 수정 (POST)
	@RequestMapping(value="/updateMem2" , method=RequestMethod.POST)	
	public String mem_updatePOST(MultipartHttpServletRequest request, Model model)throws Exception {
		
		String me_image = "";
		
		MultipartFile file = request.getFile("me_image");
		
		if(file.getOriginalFilename() == "") {
			me_image = request.getParameter("default_file");
			
		}else {
			String file_path = request.getSession().getServletContext().getRealPath("/resources/upload/mem_image");
			
			String uuid = UUID.randomUUID().toString();
			
			me_image = uuid + "_" + file.getOriginalFilename();
			
			file.transferTo(new File(file_path + "/" + me_image));
			
			File f = new File(file_path + "/" + request.getParameter("default_file"));
			if(f.exists()) {
				f.delete();
			}
		}
		
		memberVO vo = new memberVO();
		
		vo.setMe_id(Integer.parseInt((String)request.getParameter("me_id")));
		vo.setMe_email((String) request.getParameter("me_email"));
		vo.setMe_name((String)request.getParameter("me_name"));
		vo.setMe_pwd((String) request.getParameter("me_pwd"));
		vo.setMe_extension((String) request.getParameter("me_extension"));
		vo.setMe_dept((String) request.getParameter("me_dept"));
		vo.setMe_posi((String) request.getParameter("me_posi"));
		vo.setMe_image(me_image);
		
		int result = accountService.memUpdate(vo);
		model.addAttribute("updateMem_result", result);
		
		return "redirect:/infoMem";
	}
	
	
	// 회원 탈퇴 GET
	@RequestMapping(value = "/deleteMem", method=RequestMethod.GET)
	public String deleteMem(Model model)throws Exception {
		List<memberVO> listMem = accountService.memList();
		
		model.addAttribute("listMem", listMem);
		
		return "/account/deleteMem";
	}
	
	//회원 탈퇴 POST
	@RequestMapping(value = "/deleteMem" , method=RequestMethod.POST)
	public String deleteMemPOST(MultipartHttpServletRequest request, HttpSession session, Model model) throws Exception {

		memberVO vo = new memberVO();
		
		vo.setMe_id(Integer.parseInt((String) request.getParameter("em_id")));
		vo.setMe_email((String) request.getParameter("em_email"));
		vo.setMe_pwd((String) request.getParameter("em_pwd"));
		vo.setMe_image((String) request.getParameter("default_file"));
		
		int result = accountService.memDelete(vo);
		
		if(result == 1) {
			String file_path = request.getSession().getServletContext().getRealPath("resources/update/mem_Image");
			File f = new File(file_path + "/" + request.getParameter("default_file"));
			if(f.exists()) {
				f.delete();
			}
		}

		model.addAttribute("deleteMem_result", result);
		
		return "redirect:/account/deleteMem";
	}
}