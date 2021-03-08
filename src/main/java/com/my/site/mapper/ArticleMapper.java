package com.my.site.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {	
	void insert(Map<String, Object> param);		
}
