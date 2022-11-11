package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.AdminDAO;
import com.soft.vo.CategoryVO;


@Service
public class AdminServiceImpl implements AdminService{

	@Inject
	private AdminDAO adminDAO;

	@Override
	public List<CategoryVO> category() throws Exception {
		return adminDAO.category();
	}
	
}
