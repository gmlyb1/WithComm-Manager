package com.soft.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.soft.dao.BoardDAO;
import com.soft.vo.boardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(boardVO vo) throws Exception {
		 boardDAO.insertBoard(vo);
	}
	
	@Override
	public List<boardVO> BoardList() throws Exception {
		return boardDAO.BoardList();
	}

	@Override
	public boardVO BoardRead(int board_no) throws Exception {
		return boardDAO.BoardRead(board_no);
	}


}
