package com.soft.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.boardVO;

@Mapper
public interface BoardMapper {

	//글 목록 메서드
	public List<boardVO> getList(boardVO searchVO);
	
	//글 쓰기 메서드
	public void insertBoard(boardVO searchVO);
}
