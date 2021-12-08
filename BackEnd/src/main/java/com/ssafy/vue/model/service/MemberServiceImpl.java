package com.ssafy.vue.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
	}

	@Override
	public List<MemberDto> allUsers() throws Exception {
		return sqlSession.getMapper(MemberMapper.class).allUser();
	}

	@Override
	public boolean deleteUser(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).deleteUser(userid);
	}
	//id 체크 만들어야됨.
	//join시에도 다시 id 체크를 실행하게 만들어야함.
	
	@Override
	public boolean userJoin(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userJoin(memberDto);
	}

	@Override
	public boolean ownUpdate(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).ownUpdate(memberDto);
	}
}
