package com.soft.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<boardVO> BoardList(boardVO vo) throws Exception {
		return boardDAO.BoardList();
	}

	@Override
	public boardVO BoardRead(int board_no) throws Exception {
		return boardDAO.BoardRead(board_no);
	}

	@Override
	public void BoardUpdate(boardVO vo) throws Exception {
		boardDAO.BoardUpdate(vo);
	}

	@Override
	public void BoardDelete(int board_no) throws Exception {
		boardDAO.BoardDelete(board_no);
		
	}

		









}
