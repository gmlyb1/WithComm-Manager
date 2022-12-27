package com.soft.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public interface ItemService {

	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception;
}
