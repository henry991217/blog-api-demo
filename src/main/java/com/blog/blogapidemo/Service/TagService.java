package com.blog.blogapidemo.Service;

import com.blog.blogapidemo.Vo.Result;
import com.blog.blogapidemo.Vo.TagVo;

import java.util.List;

public interface TagService {

    /**
     * 根据文章id查找文章内容
     * @param articleId
     * @return
     */
    List<TagVo> findTagsByArticlesId(Long articleId);


    Result hots(int i);
}

