package com.soft.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.VisitCountDAO;
import com.soft.vo.VisitCountVO;

@Service
public class VisitCountServiceImpl implements VisitCountService{

	@Inject
	private VisitCountDAO visitCountDAO;

	
	@Override
	public int insertVisitor(VisitCountVO vo) throws Exception {
		return visitCountDAO.insertVisitor(vo);
	}

}
