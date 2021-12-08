package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;

	public List<MemberDto> allUsers() throws Exception;

	public boolean userJoin(MemberDto memberDto) throws Exception;

	public boolean deleteUser(String userid) throws Exception;

	public boolean ownUpdate(MemberDto memberDto) throws Exception;
}
