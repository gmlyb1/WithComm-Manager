package com.soft.service;

import java.util.List;

import com.soft.vo.InquiryVO;


public interface InquiryService {

	public List<InquiryVO> selectInquiryList() throws Exception;
	
	public InquiryVO selectInquiryDetail(int inq_no) throws Exception;
	
	public void insertInquiry(InquiryVO vo) throws Exception;
	
	public void updateState(InquiryVO vo) throws Exception;
}
