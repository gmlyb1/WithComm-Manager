package com.soft.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.dao.ItemDAO;
import com.soft.util.FileUtils;
import com.soft.vo.ItemVO;

@Service
public class ItemServiceImpl implements ItemService{

	@Inject
	private ItemDAO itemDAO;
	
	@Inject
	private FileUtils fileUtils;
	
	@Override
	public void itemInsert(ItemVO itemVO, MultipartHttpServletRequest mpRequest) throws Exception {
		itemDAO.itemInsert(itemVO, mpRequest);
		
//		Map<String, Object> itemMainImg = this.fileUtils.itemMainImg(itemVO,mpRequest);
//		this.itemDAO.itemMainImg(itemMainImg);
//		this.itemDAO.itemMainFile(itemMainImg);
		
//		Map<String, Object> itemsubImg = this.fileUtils.itemSubImg(itemVO,mpRequest);
//		this.itemDAO.itemSubImg(itemSubImg);
//		this.itemDAO.itemMainFile(itemSubImg);
		
		for(int i = 0; i < (itemVO.getItem_option()).length; i++) {
			String itemOptionContent = itemVO.getItem_option()[i];
			int itemOptionVol = itemVO.getItem_vol()[i];
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("item_option", itemOptionContent);
			map.put("item_no", Integer.valueOf(itemVO.getItem_no()));
			map.put("item_vol", Integer.valueOf(itemOptionVol));
//			this.itemDAO.itemOptionInsert(map);
		}
	}
}
