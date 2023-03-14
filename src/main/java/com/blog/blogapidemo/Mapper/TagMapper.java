package com.blog.blogapidemo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blogapidemo.Pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);
//动态sql
    /**
     * 查询最热的标签 前n条
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);
    //动态sql
    List<Tag> findTagsByTagIds(List<Long> tagIds);
    //动态sql
}