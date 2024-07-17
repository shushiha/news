package com.jp.ht.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.ht.mapper.CategoryMapper;
import com.jp.ht.pojo.Category;
import com.jp.ht.service.CategoryService;
import com.jp.ht.utils.ThreadLocalUtil;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public void add(Category category) {
		category.setCreateTime(LocalDateTime.now());
		category.setUpdateTime(LocalDateTime.now());
		
		Map<String,Object> map = ThreadLocalUtil.get();
		Integer userId = (Integer) map.get("id");
		category.setCreateUser(userId);
		categoryMapper.add(category);
	}
	@Override
	public List<Category> list() {
		Map<String,Object> map = ThreadLocalUtil.get();
		Integer userId = (Integer) map.get("id");
		return categoryMapper.list(userId);
	}
	@Override
	public Category findById(Integer id) {
		Category c = categoryMapper.findById(id);
		return c;
	}
	@Override
	public void update(Category category) {
		category.setUpdateTime(LocalDateTime.now());
		categoryMapper.update(category);
	}
	@Override
	public void delete(Integer id) {
		categoryMapper.delete(id);
	}

}
