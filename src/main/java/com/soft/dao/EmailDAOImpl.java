package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soft.controller.EmailController;
import com.soft.vo.MailVO;
import com.soft.vo.memberVO;
import com.soft.vo.sendMailVO;

public class EmailDAOImpl implements EmailDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	private static final String namespace = "com.soft.dao.EmailDAO";

	@Override
	public List<MailVO> mailList(String mail_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("namespace.mailList", mail_id);
	}

	@Override
	public boolean sendEmailChk(String em_email) throws Exception {

		boolean check = sqlSession.selectOne("namespace.emailChk", em_email);
		logger.info("mailDAO : 보내려는 메일 주소 존재 여부 : "+check);
		return check;
	}

	@Override
	public void mailWrite(MailVO vo) throws Exception {
		// db에 있는 제일 마지막에 쓴 mail_num 불러오기
		String tmp = sqlSession.selectOne("namespace.mailnumCnt");
		int num = 0;
		if ( tmp != null) num = Integer.parseInt(tmp);
		
		vo.setMail_num(++num);
		
		logger.info("mailDAO : 전송하려는 메일 정보 : "+vo);
		
		sqlSession.insert("sqlSession.mailWrite", vo);
		
		tmp = sqlSession.selectOne("namespace.sendmailnumCnt");
		num = 0;
		if (tmp != null) num = Integer.parseInt(tmp);
		
		vo.setMail_num(++num);
		sqlSession.insert("namespace.mailWriteCopy",vo);
	
	}

	@Override
	public List<memberVO> empSelect() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("namespace.empSelect");
	}

	@Override
	public MailVO recevRead(int mail_num) throws Exception {
		MailVO mvo = sqlSession.selectOne("namespace.recevRead", mail_num);
		
		if(mvo.getMail_readCheck().equals("0")) {
		   mvo.setMail_readCheck("1");
		   sqlSession.update("namespace.recevReadCheckUpdate", mail_num);
		}
		
		return mvo;
	}

	@Override
	public String mailName(String mailName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("namespace.recevAndSend", mailName);
	}

	@Override
	public void mailDelete(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("namespace.deleteMail",mail_num);
	}

	@Override
	public void mailReadUpdate(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("namespace.updateReadChk",mail_num);
	}

	@Override
	public void mailKeepUpdate(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("namespace.updateKeep",mail_num);
	}

	@Override
	public List<sendMailVO> sendMailList(String mail_email) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("namespace.sendMailList", mail_email);
	}

	@Override
	public sendMailVO sendRead(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("nameapce.sendRead", mail_num);
	}

	@Override
	public void mailDelete2(int mail_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("namespace.deleteMail2",mail_num);
	}

	@Override
	public List<MailVO> mailKeepList(String mail_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("namespace.mailKeepList", mail_id);
	}
	

}
