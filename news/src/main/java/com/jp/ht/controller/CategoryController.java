package com.jp.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.ht.pojo.Category;
import com.jp.ht.pojo.Result;
import com.jp.ht.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping
	public Result add(@RequestBody @Validated Category category) {
		categoryService.add(category);
		return Result.success();
	}
	@GetMapping
	public Result<List<Category>> list(){
		List<Category> cs = categoryService.list();
		return Result.success(cs);
	}
	@GetMapping("/detail")
	public Result<Category> detail(Integer id){
		
		Category c = categoryService.findById(id);
		return Result.success(c);
	}
	@PutMapping
	public Result update(@RequestBody @Validated Category category) {
		categoryService.update(category);
		return Result.success();
	}
	@DeleteMapping
	public Result<Category> delete(Integer id) {
		categoryService.delete(id);
		return Result.success();
	}
}
