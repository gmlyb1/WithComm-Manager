package com.soft.service;

import java.util.List;

import com.soft.vo.CategoryVO;

public interface AdminService {

	//카테고리
	public List<CategoryVO> category() throws Exception;
}
