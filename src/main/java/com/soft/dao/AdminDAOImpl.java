package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.CategoryVO;

public class AdminDAOImpl implements AdminDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.AdminDAO";

	@Override
	public List<CategoryVO> category() throws Exception {
		return sqlSession.selectList("namespace.category");
	}
}
