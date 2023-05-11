package com.soft.dao;

import java.util.List;

import com.soft.vo.boardVO;
import com.soft.vo.memberVO;

public interface MemberDAO {


	public void register(memberVO vo) throws Exception;
	
	public memberVO login(memberVO vo) throws Exception;
	
	public int passChk(memberVO vo) throws Exception;

	public int idChk(memberVO vo) throws Exception;
	
	public memberVO memberInfoSearch(memberVO mVO)throws Exception;
	
	public void memberUpdate(String me_id) throws Exception;
	
	public List<memberVO> memberManage(memberVO mVO)throws Exception;
	
	public void memberDelete(int me_id) throws Exception;
	
	public void updateImg(String memberImg, String me_id);
	
	// 관리자 지정
	public void selectManage(memberVO mvo) throws Exception;
	
	public void stateChk(memberVO mvo) throws Exception;
	
	// 관리자 회원등록
	public void insertAccount(memberVO vo) throws Exception;
	
	public int memberChoice(memberVO vo) throws Exception;
}
