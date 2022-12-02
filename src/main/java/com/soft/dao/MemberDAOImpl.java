package com.soft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.soft.vo.memberVO;

public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.soft.dao.MemberDAO";

	@Override
	public void register(memberVO vo) throws Exception {
		sqlSession.insert("namespace.register", vo);
	}

	@Override
	public memberVO login(memberVO vo) throws Exception {
		return sqlSession.selectOne("namespace.login", vo);
	}

	@Override
	public int idChk(memberVO vo) throws Exception {
		int result = sqlSession.selectOne("namespace.passChk",vo);
		return result;
	}

	@Override
	public int passChk(memberVO vo) throws Exception {
		int result = sqlSession.selectOne("namespace.idChk",vo);
		return result;
	}

	@Override
	public memberVO memberInfoSearch(memberVO mVO) throws Exception {
		return sqlSession.selectOne("namespace.memberInfoSearch",mVO);
	}

	@Override
	public void memberUpdate(String me_email,String hashedPw) throws Exception {
		Map<String, Object>map = new HashMap<String,Object>();	
		map.put("me_email", me_email);
		map.put("me_pwd", hashedPw);
		
		sqlSession.update("namespace.memberUpdate",map);
	}
	@Override
	public String pwCheck(String me_email) throws Exception {
		return sqlSession.selectOne("namespace.pwCheck", me_email);
	}
	
	
	@Override
	public List<memberVO> memberManage(memberVO mVO) throws Exception{
		return sqlSession.selectList("namespace.memberManage",mVO );
	}

	@Override
	public void memberDelete(int me_id) throws Exception {
		sqlSession.delete("namespace.memberDelete", me_id);
	}

	


}
