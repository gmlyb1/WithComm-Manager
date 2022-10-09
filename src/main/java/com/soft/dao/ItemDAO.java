package com.soft.dao;

import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public interface ItemDAO {

	// ��ǰ ���
	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest request);
	

	public void itemOptionInsert(Map<String, Object> map);


	public void itemMainImg();


	public void itemSubImg();


	public void itemMainFile();
}
