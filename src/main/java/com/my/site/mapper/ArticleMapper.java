package com.my.site.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.my.site.dto.Article;

@Mapper
public interface ArticleMapper {	
	void insert(Map<String, Object> param);
	List<Article> getArticleList();
}
