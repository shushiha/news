package com.jp.ht.service;

import com.jp.ht.pojo.Article;
import com.jp.ht.pojo.PageBean;

public interface ArticleService {

	void add(Article article);

	PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

}
