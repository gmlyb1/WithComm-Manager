package com.soft.dao;

import java.util.List;

import com.soft.vo.InquiryVO;

public interface InquiryDAO {

	public List<InquiryVO> selectInquiryList() throws Exception;
	
	public InquiryVO selectInquiryDetail(int inq_no) throws Exception;
	
	public void insertInquiry(InquiryVO vo) throws Exception;
	
	public void updateState(InquiryVO vo) throws Exception;
}
