package com.soft.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.vo.ItemVO;
import com.soft.vo.boardVO;


@Component
public class FileUtils {
	
	private static final String filePath = "C:\\mp\\file\\"; // 파일이 저장될 위치
	
	public List<Map<String, Object>> parseInsertFileInfo(boardVO bVO, MultipartHttpServletRequest request) throws Exception {
		
		Iterator<String> iterator = request.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int bno = bVO.getBoard_no();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = request.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				listMap = new HashMap<String,Object>();
				listMap.put("BNO", bno);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				
			}
		}
			return list;
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-","");
	}

	public Map<String, Object> itemMainImg(ItemVO itemVO, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> itemSubImg(ItemVO itemVO, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
