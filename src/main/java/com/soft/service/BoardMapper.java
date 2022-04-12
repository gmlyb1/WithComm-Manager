package com.soft.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> getBoardList(BoardVO searchVO);
}
