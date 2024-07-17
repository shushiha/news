package com.jp.ht.service;

import java.util.List;

import com.jp.ht.pojo.Category;

public interface CategoryService {

	void add(Category category);

	List<Category> list();

	Category findById(Integer id);

	void update(Category category);

	void delete(Integer id);

}
