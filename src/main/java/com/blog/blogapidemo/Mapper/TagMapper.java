package com.blog.blogapidemo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blogapidemo.Pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);
//多表查询sql
    /**
     * 查询最热的标签 前n条
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);
    //mybatis
    List<Tag> findTagsByTagIds(List<Long> tagIds);
    //mybatis
}
