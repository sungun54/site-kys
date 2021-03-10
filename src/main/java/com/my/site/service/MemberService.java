package com.my.site.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.site.dto.ResultData;
import com.my.site.mapper.MemberMapper;
import com.my.site.util.Util;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;

	public ResultData checkLoginIdJoinable(String loginId) {
		int count = memberMapper.getLoginIdDupCount(loginId);

		if (count == 0) {
			return new ResultData("S-1", "가입가능한 로그인 아이디 입니다.", "loginId", loginId);
		}

		return new ResultData("F-1", "이미 사용중인 로그인 아이디 입니다.", "loginId", loginId);
	}

	public ResultData checkNicknameJoinable(String nickname) {
		int count = memberMapper.getNicknameDupCount(nickname);

		if (count == 0) {
			return new ResultData("S-1", "사용가능한 닉네임 입니다.", "nickname", nickname);
		}
		return new ResultData("F-1", "이미 사용중인 닉네임 입니다.", "nickname", nickname);
	}

	public ResultData checkEmailJoinable(String email) {
		int count = memberMapper.getEmailDupCount(email);

		if (count == 0) {
			return new ResultData("S-1", "사용가능한 이메일 입니다.", "email", email);
		}

		return new ResultData("F-1", "이미 사용중인 이메일 입니다.", "email", email);
	}

	public int join(Map<String, Object> param) {
		Util.changeMapKey(param, "loginPwReal", "loginPw");
		System.out.println(param.get("loginPw"));
		memberMapper.insert(param);
		int memberId = Util.getAsInt(param.get("id"));

		return memberId;
	}

}
