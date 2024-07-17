package com.jp.ht.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jp.ht.mapper.ArticleMapper;
import com.jp.ht.pojo.Article;
import com.jp.ht.pojo.PageBean;
import com.jp.ht.service.ArticleService;
import com.jp.ht.utils.ThreadLocalUtil;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public void add(Article article) {
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());
		 Map<String, Object> map = ThreadLocalUtil.get();
		 Integer userId = (Integer) map.get("id");
		 article.setCreateUser(userId);
		articleMapper.add(article);
	}
	@Override
	public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
		PageBean<Article> pb = new PageBean<>();
		
		PageHelper.startPage(pageNum,pageSize);
		Map<String, Object> map = ThreadLocalUtil.get();
		Integer userId = (Integer) map.get("id");
		List<Article> as = articleMapper.list(userId,categoryId,state);
		Page<Article> p = (Page<Article>) as;
		
		pb.setTotal(p.getTotal());
		pb.setItems(p.getResult());
		return pb;
	}

}
