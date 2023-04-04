package com.blog.blogapidemo.Service;

import com.blog.blogapidemo.Vo.Params.PageParams;
import com.blog.blogapidemo.Vo.Result;

public interface ArticleService{
    /**
     * 分頁查詢
     *
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    Result hotArticle(int limit);
}
