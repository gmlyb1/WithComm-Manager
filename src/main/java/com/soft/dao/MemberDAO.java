package com.soft.dao;

import java.util.List;


import com.soft.vo.memberVO;

public interface MemberDAO {


	// ȸ������
	public void register(memberVO vo) throws Exception;
	
	// �α���
	public memberVO login(memberVO vo) throws Exception;
}
