package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.service.BoardService;
import com.soft.vo.boardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<boardVO> getList(boardVO searchVO) {
		return mapper.getList(searchVO);
	}

	
}
