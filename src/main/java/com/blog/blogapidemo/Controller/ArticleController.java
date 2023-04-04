package com.blog.blogapidemo.Controller;

import com.blog.blogapidemo.Service.ArticleService;
import com.blog.blogapidemo.Vo.Params.PageParams;
import com.blog.blogapidemo.Vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    /**
     * 文章列表
     * @param pageParams
     * @return 返回文章列表
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    /**
     * 最热文章
     * @return 返回右侧最热文章，按降序排列
     */
    @PostMapping("hot")
    public Result hotArticle()
    {
        int limit=5;
        return articleService.hotArticle(limit);
    }
}
