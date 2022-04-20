package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.BoardDAO;
import com.soft.vo.boardVO;

@Service
public class BoardServcieImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<boardVO> getList(boardVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(boardVO searchVO) {
		// TODO Auto-generated method stub
		
	}

}
