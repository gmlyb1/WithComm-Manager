package com.soft.dao;

import java.util.List;

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
	public void memberUpdate(memberVO mVO) throws Exception {
			sqlSession.update("namespace.memberUpdate",mVO);
	}

	@Override
	public List<memberVO> memberManage(memberVO mVO) throws Exception{
		return sqlSession.selectList("namespace.memberManage",mVO );
	}

	@Override
	public void memberDelete(int me_id) throws Exception {
		sqlSession.delete("namespace.memberDelete", me_id);
	}


}
