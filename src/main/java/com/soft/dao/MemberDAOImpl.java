package com.soft.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.soft.vo.memberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;

	private static final String namespace = "com.soft.dao.MemberDAO";

	@Override
	public void register(memberVO vo) throws Exception {
			session.insert(namespace+".registerID",vo);
	}

	@Override
	public memberVO login(memberVO vo) throws Exception {
		return session.selectOne(namespace+".login",vo);
	}

	@Override
	public int idChk(memberVO vo) throws Exception {
		int result = session.selectOne(namespace+".idChk",vo);
		return result;
	}

	@Override
	public int passChk(memberVO vo) throws Exception {
		int result = session.selectOne(namespace+".passChk",vo);
		return result;
	}

	


}
