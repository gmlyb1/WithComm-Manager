package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mysql.cj.util.StringUtils;
import com.soft.dao.MemberDAO;
import com.soft.vo.memberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;

	@Override
	public void register(memberVO vo) throws Exception {
		memberDAO.register(vo);
	}

	@Override
	public memberVO login(memberVO vo) throws Exception {
		return memberDAO.login(vo);
	}

	
	@Override
	public int idChk(memberVO vo) throws Exception {
		  int result = memberDAO.idChk(vo);
		  return result; 
	}
	  
	  @Override
	  public int passChk(memberVO vo) throws Exception { 
		  int result =  memberDAO.passChk(vo); 
		  return result;
	}

	@Override
	public memberVO memberInfoSearch(memberVO mVO) throws Exception {
		return memberDAO.memberInfoSearch(mVO);
	}

	@Override
	public void memberUpdate(String me_id) throws Exception{
		memberDAO.memberUpdate(me_id);
	}
	
	
	@Override
	public List<memberVO> memberManage(memberVO mVO)throws Exception {
		return memberDAO.memberManage(mVO);
	}

	@Override
	public void memberDelete(int me_id) throws Exception {
		memberDAO.memberDelete(me_id);
	}

	@Override
	public void updateImg(String memberImg, String me_id) {
		memberDAO.updateImg(memberImg, me_id);
	}

	@Override
	public void selectManage(memberVO mvo) throws Exception {
		 memberDAO.selectManage(mvo);
	}
	
	

	@Override
	public void insertAccount(memberVO vo) throws Exception {
		memberDAO.insertAccount(vo);
	}

	@Override
	public int memberChoice(memberVO vo) throws Exception {
		return memberDAO.memberChoice(vo);
	}

	@Override
	public void approvalChk(memberVO mvo) throws Exception {
		memberDAO.approvalChk(mvo);
	}

	

	
	
	 
	
	
}
