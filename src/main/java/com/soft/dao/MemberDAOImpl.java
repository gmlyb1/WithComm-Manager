package com.soft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.memberVO;

public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.soft.dao.MemberDAO";

	@Override
	public void register(memberVO vo) throws Exception {
		sqlSession.insert("namespace.register", vo);
	}

	@Override
	public memberVO login(memberVO vo) throws Exception {
		return sqlSession.selectOne("namespace.login", vo);
	}

	@Override
	public int idChk(memberVO vo) throws Exception {
		int result = sqlSession.selectOne("namespace.passChk",vo);
		return result;
	}

	@Override
	public int passChk(memberVO vo) throws Exception {
		int result = sqlSession.selectOne("namespace.idChk",vo);
		return result;
	}

	@Override
	public memberVO memberInfoSearch(memberVO mVO) throws Exception {
		return sqlSession.selectOne("namespace.memberInfoSearch",mVO);
	}

	@Override
	public void memberUpdate(String me_id) throws Exception {
		
		sqlSession.update("namespace.memberUpdate",me_id);
	}
	
	
	@Override
	public List<memberVO> memberManage(memberVO mVO) throws Exception{
		return sqlSession.selectList("namespace.memberManage",mVO );
	}

	@Override
	public void memberDelete(int me_id) throws Exception {
		sqlSession.delete("namespace.memberDelete", me_id);
	}

	@Override
	public void updateImg(String memberImg, String me_id) {
		sqlSession.update("namespace.updateImg", me_id);
	}

	@Override
	public void selectManage(memberVO mvo) throws Exception {
		sqlSession.update("namespace.selectManage", mvo);
	}

	@Override
	public void stateChk(memberVO mvo) throws Exception {
		sqlSession.update("namespace.stateChk", mvo);
	}

	@Override
	public void insertAccount(memberVO vo) throws Exception {
		sqlSession.insert("namespace.insertAccount", vo);
	}

	@Override
	public int memberChoice(memberVO vo) throws Exception {
		return sqlSession.update("namespace.memberChoice",vo);
	}
	


}
