package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.soft.dao.AccountDAO;
import com.soft.vo.memberVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountDAO accountDAO;
	
	// ID �ߺ�üũ
	@Override
	public int checkMemId(int me_id) throws Exception {
		int result = accountDAO.checkMemId(me_id);
		return result;
	}

	// ȸ������
	@Override
	public void memJoin(memberVO vo) throws Exception {
		accountDAO.joinMem(vo);
	}

	// �α���
	@Override
	public List memLogin(memberVO vo) throws Exception {
		List loginList = accountDAO.loginMem(vo);
		return loginList;
	}
	
	//ȸ����ȸ
	@Override
	public memberVO memInfo(int me_id) throws Exception {
		memberVO resultVO = accountDAO.infoMem(me_id);
		return resultVO;
	}
	
	//ȸ�� ����
	@Override
	public int memUpdate(memberVO vo) throws Exception {
		int result = accountDAO.updateMem(vo);
		return result;
	}
	
	//ȸ�� Ż��
	@Override
	public int memDelete(memberVO vo) throws Exception {
		
		int result = accountDAO.deleteMem(vo);
		return result;
	}

	// ȸ������Ʈ
	@Override
	public List<memberVO> memList() throws Exception {
		List<memberVO> listMem = accountDAO.listMem();
		
		return listMem;
	}

}
