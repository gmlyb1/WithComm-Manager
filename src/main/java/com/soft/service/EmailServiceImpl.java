package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.soft.controller.EmailController;
import com.soft.dao.EmailDAO;
import com.soft.vo.MailVO;
import com.soft.vo.memberVO;
import com.soft.vo.sendMailVO;

@Service
public class EmailServiceImpl implements EmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Inject
	private EmailDAO emailDAO;

	@Override
	public List<MailVO> mailList(String mail_id) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.mailList(mail_id);
	}

	@Override
	public boolean sendEmailChk(String em_email) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.sendEmailChk(em_email);
	}

	@Override
	public void mailWrite(MailVO vo) throws Exception {
		// TODO Auto-generated method stub
		emailDAO.mailWrite(vo);
	}

	@Override
	public List<memberVO> empSelect() throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.empSelect();
	}

	@Override
	public MailVO recevRead(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.recevRead(mail_num);
	}

	@Override
	public String mailName(String mailName) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.mailName(mailName);
	}

	@Override
	public void mailDelete(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		emailDAO.mailDelete(mail_num);
	}

	@Override
	public void mailReadUpdate(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		emailDAO.mailReadUpdate(mail_num);
	}

	@Override
	public void mailKeepUpdate(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		emailDAO.mailKeepUpdate(mail_num);
	}

	@Override
	public List<sendMailVO> sendMailList(String mail_email) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.sendMailList(mail_email);
	}

	@Override
	public sendMailVO sendRead(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.sendRead(mail_num);
	}

	@Override
	public void mailDelete2(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		emailDAO.mailDelete2(mail_num);
	}

	@Override
	public List<MailVO> mailKeepList(String mail_id) throws Exception {
		// TODO Auto-generated method stub
		return emailDAO.mailKeepList(mail_id);
	}
	

}
