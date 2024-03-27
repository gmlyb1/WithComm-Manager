package com.soft.dao;

import java.util.List;

import com.soft.vo.MailVO;
import com.soft.vo.memberVO;
import com.soft.vo.sendMailVO;


public interface EmailDAO {

	// 메일 목록 조회
	public List<MailVO> mailList(String mail_id) throws Exception;

	// 메일 쓰기 - 해당 이메일 주소가 존재하는지 체크
	public boolean sendEmailChk(String em_email) throws Exception;
	
	// 메일 쓰기
	public void mailWrite(MailVO vo) throws Exception;
	
	// 직원 정보 조회 (메일 쓰기)
	public List<memberVO> empSelect() throws Exception;
	
	// 수신 메일 읽기
	public MailVO recevRead(int mail_num) throws Exception;
	
	// 수신자/발신자 이름
	public String mailName(String mailName) throws Exception;
	
	// 메일 삭제하기
	public void mailDelete(int mail_num) throws Exception;
	
	// 메일 읽음 처리
	public void mailReadUpdate(int mail_num) throws Exception;
	
	// 중요 보관함 처리
	public void mailKeepUpdate(int mail_num) throws Exception;
	
	// 발신 메일 목록 조회
	public List<sendMailVO> sendMailList(String mail_email) throws Exception;
	
	// 발신 메일 읽기
	public sendMailVO sendRead(int mail_num) throws Exception;
	
	// 발신 메일 삭제
	public void mailDelete2(int mail_num) throws Exception;
	
	// 중요 보관함 불러오기
	public List<MailVO> mailKeepList(String mail_id) throws Exception;
	
}
