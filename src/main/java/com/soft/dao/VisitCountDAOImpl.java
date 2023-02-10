package com.soft.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.VisitCountVO;

public class VisitCountDAOImpl implements VisitCountDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.VisitCountDAO";

	@Override
	public int insertVisitor(VisitCountVO vo) throws Exception {
		return sqlSession.insert("namespace.insertVisitor",vo);
	}
}
