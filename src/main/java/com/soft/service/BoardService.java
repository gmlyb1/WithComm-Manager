package com.soft.service;

import java.util.List;

import com.soft.vo.BoardVO;

public interface BoardService {

	List<BoardVO> getBoardList(BoardVO searchVO);
}
