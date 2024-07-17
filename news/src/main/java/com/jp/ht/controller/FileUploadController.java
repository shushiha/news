package com.jp.ht.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jp.ht.pojo.Result;

@RestController
public class FileUploadController {
	@PostMapping("/upload")
	public Result<String> upload(MultipartFile file) throws IllegalStateException, IOException{
		String originalFilename = file.getOriginalFilename();
		//保证名称文件唯一防止覆盖
		String fileName=UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
		file.transferTo(new File("C:\\Users\\ht201\\OneDrive\\デスクトップ\\SHU\\下载\\files\\"+fileName));
		return Result.success("url.....");
	}
}
