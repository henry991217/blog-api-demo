package com.blog.blogapidemo.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogapidemo.Mapper.ArticleMapper;
import com.blog.blogapidemo.Pojo.Article;
import com.blog.blogapidemo.Vo.Params.PageParams;
import com.blog.blogapidemo.Vo.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceImp implements ArticleService{


    @Autowired
    ArticleMapper articleMapper;
    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page=new Page<>(pageParams.)

        return null;

    }
}
