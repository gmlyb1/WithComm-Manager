package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.InquiryVO;

public class InquiryDAOImpl implements InquiryDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.soft.dao.InquiryDAO";
	
	@Override
	public List<InquiryVO> selectInquiryList() throws Exception {
		return sqlSession.selectList("namespace.selectInquiryList");
	}

	@Override
	public InquiryVO selectInquiryDetail(int inq_no) throws Exception {
		return sqlSession.selectOne("namespace.selectInquiryDetail",inq_no);
	}

	@Override
	public void insertInquiry(InquiryVO vo) throws Exception {
		sqlSession.insert("namespace.insertInquiry", vo);
	}

	@Override
	public void updateState(InquiryVO vo) throws Exception {
		sqlSession.update("namespace.updateState",vo);
	}

}
