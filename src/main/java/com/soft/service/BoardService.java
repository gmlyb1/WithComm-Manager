package com.soft.service;

import java.util.List;

import com.soft.vo.boardVO;

public interface BoardService {

	List<boardVO> getList(boardVO searchVO);
}
