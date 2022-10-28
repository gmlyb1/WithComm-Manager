package com.soft.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;

public interface ItemService {

	
	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest request);

}
