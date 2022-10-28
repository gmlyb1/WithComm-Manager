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
	public void memberUpdate(memberVO mVO) throws Exception{
		if(!StringUtils.isNullOrEmpty(mVO.getMe_pwd())) {
			try {
				String enpassword = encryptPassword(mVO.getMe_pwd());
				mVO.setMe_pwd(enpassword);
				memberDAO.memberUpdate(mVO);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		memberDAO.memberUpdate(mVO);
	}

	private String encryptPassword(String me_pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<memberVO> memberManage(memberVO mVO)throws Exception {
		return memberDAO.memberManage(mVO);
	}

	
	
	 
	
	
}
