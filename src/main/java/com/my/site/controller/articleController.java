package com.my.site.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.site.service.ArticleService;

@Controller
public class articleController {	
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/usr/article/write")
	public String showArticleWrite() {		
		return "article/write";
	}
	
	@RequestMapping("/usr/article/doWrite")	
	public String articleDoWrite(@RequestParam Map<String, Object> param) {
		articleService.write(param);
		
		return "home/main";		
	}
	
}
