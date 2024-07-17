package com.jp.ht.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.ht.pojo.Article;
import com.jp.ht.pojo.PageBean;
import com.jp.ht.pojo.Result;
import com.jp.ht.service.ArticleService;



@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@PostMapping
	public Result add(@RequestBody @Validated Article article) {
		articleService.add(article);
		return Result.success();
	}
	@GetMapping
	public Result<PageBean<Article>> list(Integer pageNum, Integer pageSize,
			@RequestParam(required = false) Integer categoryId,@RequestParam(required = false) String state){
		
		PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);
		return Result.success(pb);
	}
}
