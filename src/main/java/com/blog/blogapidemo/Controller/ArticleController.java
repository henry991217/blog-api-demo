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
@RequestMapping("article")
public class ArticleController {

    /**
     * 文章列表
     *
     * @param pageParams
     * @return
     */
    @Autowired
    ArticleService service;

    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        return service.listArticle(pageParams);
    }


}
