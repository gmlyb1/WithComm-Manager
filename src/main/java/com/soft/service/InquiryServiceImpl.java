package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.InquiryDAO;
import com.soft.vo.InquiryVO;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Inject
	private InquiryDAO inquiryDAO;
	
	public List<InquiryVO> selectInquiryList() throws Exception {
		return inquiryDAO.selectInquiryList();
	}

	@Override
	public InquiryVO selectInquiryDetail(int inq_no) throws Exception {
		return inquiryDAO.selectInquiryDetail(inq_no);
	}

	@Override
	public void insertInquiry(InquiryVO vo) throws Exception {
		inquiryDAO.insertInquiry(vo);
	}

	@Override
	public void updateState(InquiryVO vo) throws Exception {
		inquiryDAO.updateState(vo);
	}
}
