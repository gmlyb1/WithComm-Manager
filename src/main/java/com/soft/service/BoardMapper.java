package com.soft.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.boardVO;

@Mapper
public interface BoardMapper {

	public List<boardVO> getBoardList(boardVO searchVO);
}
