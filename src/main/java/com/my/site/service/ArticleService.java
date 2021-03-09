package com.my.site.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.site.dto.Article;
import com.my.site.dto.Board;
import com.my.site.mapper.ArticleMapper;
import com.my.site.mapper.BoardMapper;
import com.my.site.util.Util;

@Service
public class ArticleService {
	
	@Autowired ArticleMapper articleMapper;
	@Autowired BoardMapper boardMapper;
	
	public int write(Map<String, Object> param) {
		articleMapper.insert(param);
		int id = Util.getAsInt(param.get("id"));

		return id;	
	}

	public Board getBoardByCode(String boardCode) {		
		return boardMapper.getBoardByBoardCode(boardCode);
	}

	public List<Article> getForPrintArticles() {
		return articleMapper.getArticleList();
	}	
	
}
