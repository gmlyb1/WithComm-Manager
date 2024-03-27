package com.soft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.soft.service.EmailService;
import com.soft.vo.MailVO;
import com.soft.vo.memberVO;
import com.soft.vo.sendMailVO;

@Controller
@RequestMapping("/mail/*")
public class EmailController {

	
		@Inject
		private EmailService emailService;
		
		private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
		
		@RequestMapping(value="/recevMail" , method=RequestMethod.GET)
		public void recevMail(Model model, HttpSession session) throws Exception {
			
			memberVO mvo = (memberVO)session.getAttribute("member");
			
			model.addAttribute("mailList", emailService.mailList(mvo.getMe_email()));
		}
		
		@RequestMapping(value="/recevRead" , method=RequestMethod.GET)
		public void readDetail_recevMail(@RequestParam("mail_num") int mail_num, Model model) throws Exception {
			
			MailVO mvo = emailService.recevRead(mail_num);
			String recName = emailService.mailName(mvo.getMail_id());
			String sendName = emailService.mailName(mvo.getMail_email());
			
			model.addAttribute("recevReadDetail", mvo);
			model.addAttribute("recName", recName);
			model.addAttribute("sendName", sendName);
			
			
		}
		
		@RequestMapping(value="/empSelect" , method = RequestMethod.GET)
		public void empSelect(Model model) throws Exception {
			
			model.addAttribute("empList", emailService.empSelect());
			
		}
		
		@RequestMapping(value="/writeMail", method = RequestMethod.GET)
		public void mailWritePage(Model model, HttpSession session) throws Exception
		{
			memberVO mvo = (memberVO)session.getAttribute("member");
			
			model.addAttribute("write_mail_id", mvo.getMe_email());
			
		}
		
		@RequestMapping(value="/writeMail" , method = RequestMethod.POST)
		public void mailWrite(MailVO vo , Model model , HttpServletResponse response, HttpSession session, HttpServletRequest request) throws Exception{
			
			memberVO mvo = (memberVO) session.getAttribute("member");
			String mail_email = mvo.getMe_email();
			vo.setMail_email(mail_email);
			
			// 보내는 이메일 주소가 member 테이블에 있는지 ?
			boolean check = emailService.sendEmailChk(vo.getMail_id());
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			if(!check) {
				out.print("<script>alert('해당 이메일 주소가 존재하지 않습니다'); location.href='/mail/writeMail'</script>");
				out.flush();
			}
			
			else {
				// 파일 업로드
				String fileName = null;
				MultipartFile uploadFile = vo.getUploadFile();
				
				if(!uploadFile.isEmpty()) {
					String originalFileName = uploadFile.getOriginalFilename();
					String ext = FilenameUtils.getExtension(originalFileName);
					UUID uuid = UUID.randomUUID();
					fileName = uuid+"."+ext;
					
					String path = request.getSession().getServletContext().getRealPath("/"); // 절대 경로
					path += "upload\\mailUpload\\";
					
					String temp_path = path+fileName;
					logger.info("파일 명 : " + fileName);
					logger.info("path : " + temp_path);
					
					uploadFile.transferTo(new File(path+fileName));
				}
				
				// 메일 보내기
				vo.setMail_file(fileName);
				emailService.mailWrite(vo);
				
				out.println("<script>alert('전송 완료'); location.href='/maill/recevMail'</script>");
				out.flush();
			}
		}
		
		@RequestMapping(value="/filedown", method=RequestMethod.GET)
		public void mail_fileDown(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// 파일 다운로드
			String fileName = request.getParameter("fileName");
			String realFileName = "";
			
			
			logger.info("파일명 : " + fileName);
			
			try {
				String browser = request.getHeader("User-Agent");
				
				//파일 인코딩
				if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
					fileName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
				}else {
					fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
				}
			} catch (UnsupportedEncodingException ex) {
				logger.info("UnsupportedEncodingException");
			}
			
			String path = request.getSession().getServletContext().getRealPath("/");
			path += "upload\\mailUpload\\";
			
			realFileName = path+fileName;
			logger.info("절대 경로 : "+realFileName);
			
			File tmpFile = new File(realFileName);
			
			if(!tmpFile.exists())
				return;
			
			// 파일명 지정
			response.setContentType("application/octer-stream");
			response.setHeader("Content-transfer-Encoding", "binary");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			
			try {
				OutputStream os = response.getOutputStream();
				FileInputStream fis = new FileInputStream(realFileName);
				
				int Ncnt = 0;
				byte[] bytes = new byte[512];
				
				while((Ncnt = fis.read(bytes)) != -1) {
					os.write(bytes,0,Ncnt);
				}
				
				fis.close();
				os.close();
			} catch (Exception e) {
				logger.info("FileNotFoundException : "+e);
			}
		}
		
		@RequestMapping(value="/deleteMail", method=RequestMethod.POST)
		public String deleteMail(@RequestParam("mail_num_cb") int[] delete_mail_num) throws Exception {
			
			for(int mail_num : delete_mail_num) { 
				emailService.mailDelete(mail_num);
			}
			
			
			return "redirect:/mail/recevMail";
		}
		
		@RequestMapping(value="/readUpdate", method=RequestMethod.POST) 
		public String updateReadChk(@RequestParam("mail_num_cb") int[] update_read_num) throws Exception {
			
			for(int mail_num : update_read_num) {
				emailService.mailReadUpdate(mail_num);
			}
			
			return "redirect:/mail/recevMail";
		}
		
		@RequestMapping(value="/updateStar" , method=RequestMethod.GET)
		public String updateStar(@RequestParam("mail_num")int mail_num, @RequestParam("keepPage") boolean keep, Model model) throws Exception{
			
			emailService.mailKeepUpdate(mail_num);
			
			if(keep) return "redirect:/mail/impMail";
			
			return "/redirect:/mail/recevMail";
		}
		
		
		// 보낸 메일--------------------------------------
		@RequestMapping(value="/sendMail", method=RequestMethod.GET)
		public void readSendMail(Model model, HttpSession session) throws Exception{
			
			// 세션
			memberVO mvo = (memberVO)session.getAttribute("member");
		
			// 발신 메일 list
			model.addAttribute("sendMailList", emailService.sendMailList(mvo.getMe_email()));
		
		}
		
		@RequestMapping(value="/sendRead", method=RequestMethod.GET)
		public void readDetail_sendMail(@RequestParam("mail_num")int mail_num, Model model) throws Exception{
			
			sendMailVO smvo = emailService.sendRead(mail_num);
			
			model.addAttribute("sendReadDetail", smvo);
			model.addAttribute("recName", emailService.mailName(smvo.getMail_id()));
			model.addAttribute("sendName", emailService.mailName(smvo.getMail_email()));
		}
		
		@RequestMapping(value="/deleteMail2", method=RequestMethod.POST)
		public String deleteMail2(@RequestParam("mail_num_cb")int[] delete_mail_num) throws Exception{
			
			for(int mail_num : delete_mail_num) {
				emailService.mailDelete2(mail_num);
			}
			
			
			return "redirect:/mail/sendMail";
		}
		
		//중요보관함---------------------------------------
		@RequestMapping(value="/impMail", method=RequestMethod.GET)
		public void impMail(Model model, HttpSession session) throws Exception{
			
			// 세션
			memberVO mvo = (memberVO)session.getAttribute("member");
			
			// 수신 메일 list
			model.addAttribute("mailKeepList", emailService.mailKeepList(mvo.getMe_email()));
		}
}
