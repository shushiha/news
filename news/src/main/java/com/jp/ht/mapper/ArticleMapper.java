package com.jp.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.jp.ht.pojo.Article;

@Mapper
public interface ArticleMapper {
	@Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time)"
			+"values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
	void add(Article article);
	
	List<Article> list(Integer userId, Integer categoryId, String state);
	
}
