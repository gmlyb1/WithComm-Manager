package com.soft.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soft.vo.memberVO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.soft.dao.AccountDAO";
	
	// ID 중복체크
	@Override
	public int checkMemId(int me_id) throws Exception {
		
		memberVO resultVO = session.selectOne(namespace + ".count");
		int result = 0;
		
		if(resultVO != null) {
			result = 1;
		}
		
		
		return result;
	}

	// 회원가입
	@Override
	public void joinMem(memberVO vo) throws Exception {
		
		
		int result = session.insert(namespace + ".joinMem", vo);
		
	}

	// 로그인
	@Override
	public List loginMem(memberVO vo) throws Exception {
		
		int result = -2;
		
		memberVO resultVO = session.selectOne(namespace+ ".loginIncludeID" , vo);
		if(resultVO != null) {
			result = -1;
			resultVO = session.selectOne(namespace+".loginMem",vo);
			
			if(resultVO != null) {
				result = 1;
			}
		}
		
		System.out.println(" DAO : 로그인 결과 : " + result);
		
		List loginList = new ArrayList<Object>();
		loginList.add(resultVO);
		loginList.add(result);
		
		System.out.println(loginList);;
		
		return loginList;
	}

	// 회원정보
	@Override
	public memberVO infoMem(int me_id) throws Exception {
		
		memberVO resultVO = session.selectOne(namespace + ".infoMem",me_id);
		
		return resultVO;
	}
	
	// 회원수정
	@Override
	public int updateMem(memberVO vo) throws Exception {
		
		int result = session.update(namespace+ ".updateMem", vo);
		
		return result;
	}

	// 회원탈퇴
	@Override
	public int deleteMem(memberVO vo) throws Exception {
		
		int result = session.delete(namespace+ ".deleteMem", vo);
		
		return result;
	}
	
	// 리스트
	@Override
	public List<memberVO> listMem() throws Exception {
		
		List<memberVO> memList = session.selectList(namespace+ ".listMem");
		
		return memList;
	}


}
