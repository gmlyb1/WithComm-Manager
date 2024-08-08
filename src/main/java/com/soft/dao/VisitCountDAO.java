package com.soft.dao;

import java.util.List;

import com.soft.vo.VisitCountVO;

public interface VisitCountDAO {

	public int insertVisitor(VisitCountVO vo) throws Exception;
	
	public List<VisitCountVO> selectVisitList(VisitCountVO vvo) throws Exception;
	
	
}
