package com.soft.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.dao.ItemDAO;
import com.soft.dao.MemberDAO;
import com.soft.util.FileUtils;
import com.soft.vo.ItemVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired(required = false)
	@Inject
	private FileUtils fileUtils;
	
	@Inject
	private ItemDAO itemDAO;
	
	@Transactional
	@Override
	public void itemInsert(ItemVO itemVO,MultipartHttpServletRequest request) {
//		itemDAO.itemInsert(itemVO,request);
//		this.itemDAO.itemInsert(itemVO, request);
//		
//		Map<String, Object> itemMainImg = this.fileUtils.itemMainImg(itemVO,request);
//		this.itemDAO.itemMainImg();
//		this.itemDAO.itemSubImg();
//		
//		Map<String, Object> itemSubImg = this.fileUtils.itemSubImg(itemVO, request);
//		this.itemDAO.itemSubImg();
//		this.itemDAO.itemMainFile();
//		
//		
//		for(int i = 0; i < (itemVO.getItem_option()).length; i++) {
//			String itemOptionContent = itemVO.getItem_option()[i];
//			int itemOptionVol = itemVO.getItem_vol()[1];
//			Map<String, Object> map = new HashMap<>();
//			map.put("item_option", itemOptionContent);
//			map.put("item_no", Integer.valueOf(itemVO.getItem_no()));
//			map.put("item_vol", Integer.valueOf(itemOptionVol));
//			this.itemDAO.itemOptionInsert(map);
//		}
	}

	
}
