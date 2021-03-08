package com.my.site.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.site.mapper.ArticleMapper;

@Service
public class ArticleService {
	
	@Autowired
	ArticleMapper aritcleMapper;
	
	public void write(Map<String, Object> param) {
		aritcleMapper.insert(param);	
	}
	
	
}
