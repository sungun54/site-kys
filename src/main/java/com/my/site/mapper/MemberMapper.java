package com.my.site.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.my.site.dto.Member;

@Mapper
public interface MemberMapper {

	int getLoginIdDupCount(String loginId);
	int getNicknameDupCount(String nickname);
	int getEmailDupCount(String email);
	void insert(Map<String, Object> param);
	Member getMemberByLoginId(String loginId);

}
