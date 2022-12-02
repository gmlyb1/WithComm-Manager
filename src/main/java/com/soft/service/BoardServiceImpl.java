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
import com.soft.util.FileUtils;
import com.soft.vo.LogVO;
import com.soft.vo.boardVO;
import com.soft.vo.replyVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private FileUtils fileUtils;
	
	@Inject
	private BoardDAO boardDAO;
	

	// �Խñ� �ۼ�
	@Override
	public void insertBoard(boardVO vo,MultipartHttpServletRequest mpRequest) throws Exception {
		boardDAO.insertBoard(vo);
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(vo, mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			boardDAO.insertFile(list.get(i));
		}
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
	public void BoardUpdate(boardVO vo,String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
		boardDAO.BoardUpdate(vo);
		
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(vo, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i=0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				boardDAO.insertFile(tempMap);
			}else {
				boardDAO.updateFile(tempMap);
			}
		}
	
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

	@Override
	public boardVO movePage(int board_no) throws Exception {
		return boardDAO.movePage(board_no);
	}

//	@Override
//	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
//		return boardDAO.selectFileList(bno);
//	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return boardDAO.selectFileInfo(map);
	}

//	@Override
//	public void updateFile(Map<String, Object> map) throws Exception {
//		boardDAO.updateFile(map);
//	}

	


}
