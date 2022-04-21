package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	
	
}