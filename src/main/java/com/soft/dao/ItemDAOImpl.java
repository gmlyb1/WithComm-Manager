package com.soft.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public class ItemDAOImpl implements ItemDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.soft.dao.ItemDAO";
	
	@Override
	public void itemInsert(ItemVO itemVO,MultipartHttpServletRequest request) {
		sqlSession.insert("namespace.itemInsert",itemVO);
	}


	@Override
	public void itemOptionInsert(Map<String, Object> map) {
		sqlSession.insert("namespace.itemOptionInsert");
		
	}


	@Override
	public void itemMainImg() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemSubImg() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemMainFile() {
		// TODO Auto-generated method stub
		
	}

}
