package com.soft.service;

import java.util.List;

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


	@Override
	public List<VisitCountVO> selectVisitList(VisitCountVO vvo) throws Exception {
		return visitCountDAO.selectVisitList(vvo);
	}


	@Override
	public VisitCountVO visitAprvSttsCnt(VisitCountVO vvo) throws Exception {
		return visitCountDAO.visitAprvSttsCnt(vvo);
	}


	@Override
	public VisitCountVO selectVisitCount(VisitCountVO vvo) throws Exception {
		return visitCountDAO.selectVisitCount(vvo);
	}

}
