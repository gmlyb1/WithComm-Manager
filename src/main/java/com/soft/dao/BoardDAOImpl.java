package com.soft.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soft.vo.boardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.soft.dao.BoardDAO";

	// �Խñ� ����
	@Override
	public void insertBoard(boardVO vo) throws Exception {
		session.insert(namespace+".insertBoard");
	}

	// �Խñ� ���
	@Override
	public List<boardVO> BoardList() throws Exception {
		return session.selectList(namespace+".BoardList");
	}

	// �Խñ� ��ȸ
	@Override
	public boardVO BoardRead(int board_no) throws Exception {
		return session.selectOne(namespace+".BoardRead", board_no);
	}


}
