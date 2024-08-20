package com.soft.service;

import java.util.List;

import com.soft.vo.VisitCountVO;

public interface VisitCountService {

	public int insertVisitor(VisitCountVO vo) throws Exception;

	public List<VisitCountVO> selectVisitList(VisitCountVO vvo) throws Exception;

	public VisitCountVO visitAprvSttsCnt(VisitCountVO vvo) throws Exception;

	public VisitCountVO selectVisitCount(VisitCountVO vvo) throws Exception;
}
