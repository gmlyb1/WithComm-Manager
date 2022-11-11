package com.soft.dao;

import java.util.List;

import com.soft.vo.CategoryVO;

public interface AdminDAO {

	//카테고리
	public List<CategoryVO> category() throws Exception;
}
