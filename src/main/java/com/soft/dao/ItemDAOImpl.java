package com.soft.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public class ItemDAOImpl implements ItemDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.ItemDAO";

	@Override
	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception {
		sqlSession.insert("namespace.itemInsert" ,mpRequest);
	}
}
