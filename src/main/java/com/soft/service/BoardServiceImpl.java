package com.soft.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.soft.dao.BoardDAO;
import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	

	// �Խñ� �ۼ�
	@Override
	public void insertBoard(boardVO vo) throws Exception {
		boardDAO.insertBoard(vo);
		
		// Ȱ���α�
//		LogVO logVO = new LogVO();
//		logVO.setBno(vo.getBoard_no());
//		logVO.setMemberId(vo.getBoard_writer());
//		logVO.setCategori(1);
//		boardDAO.insertLog(logVO);
	}

	// �Խñ� ���
	@Override
	public List<boardVO> BoardList(boardVO vo) throws Exception {
		return boardDAO.BoardList();
	}

	//���� ������ �� ���
	@Override
	public List<boardVO> HomeBoardList(boardVO vo) throws Exception {
		return boardDAO.HomeBoardList();
	}
	
	
	// �Խñ� ��ȸ+��ȸ��
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public boardVO BoardRead(int board_no) throws Exception {
			   boardDAO.BoardHit(board_no);
		return boardDAO.BoardRead(board_no);
	}
	
	// ��� �ۼ�
	@Transactional
	@Override
	public void replyWrite(replyVO vo) throws Exception {
		boardDAO.replyWrite(vo);
		
//		boardDAO.replyCount(vo.getBoard_no(), 1);
	}

	
	// �Խñ� ����
	@Override
	public void BoardUpdate(boardVO vo) throws Exception {
		boardDAO.BoardUpdate(vo);
	}

	// �Խñ� ����
	@Override
	public void BoardDelete(int board_no) throws Exception {
		boardDAO.BoardDelete(board_no);
		
	}

	// ��� ���
	@Override
	public List<replyVO> ReadReply(int board_no) throws Exception {
		return boardDAO.ReadReply(board_no);
	}

	


}
