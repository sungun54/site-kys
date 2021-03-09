package com.my.site.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.site.dto.Article;
import com.my.site.dto.Board;
import com.my.site.service.ArticleService;
import com.my.site.util.Util;

@Controller
public class ArticleController {	
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/usr/article/{boardCode}-write")
	public String showArticleWrite(@PathVariable("boardCode") String boardCode, Model model) {		
		
		Board board = articleService.getBoardByCode(boardCode);
		model.addAttribute("board", board);
		return "article/write";
	}
	
	@RequestMapping("/usr/article/{boardCode}-doWrite")	
	public String articleDoWrite(@PathVariable("boardCode") String boardCode, Model model, @RequestParam Map<String, Object> param) {
		Board board = articleService.getBoardByCode(boardCode);
		model.addAttribute("board", board);

		Map<String, Object> newParam = Util.getNewMapOf(param, "title", "body");
		newParam.put("boardId", board.getId());
		int newArticleId = articleService.write(newParam);
		
		return "article/list";		
	}
	
	@RequestMapping("/usr/article/{boardCode}-list")
	public String showArticleList(@PathVariable("boardCode") String boardCode, Model model) {		
		Board board = articleService.getBoardByCode(boardCode);
		model.addAttribute("board", board);
		List<Article> articles = articleService.getForPrintArticles();
		model.addAttribute("articles", articles);

		return "article/list";	
	}
	
}
