package com.soft.dao;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public interface ItemDAO {

	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception;
}
