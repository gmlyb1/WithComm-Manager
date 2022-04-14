package com.soft.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.soft.vo.boardVO;

@Mapper
public interface BoardMapper {

	public List<boardVO> getList(boardVO searchVO);
}
