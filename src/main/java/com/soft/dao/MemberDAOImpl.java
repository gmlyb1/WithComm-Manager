package com.soft.dao;

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

}
