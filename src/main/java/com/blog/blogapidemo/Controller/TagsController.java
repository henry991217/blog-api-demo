package com.blog.blogapidemo.Controller;


import com.blog.blogapidemo.Service.TagService;
import com.blog.blogapidemo.Vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagsController {

    //tags/hot
    @Autowired
    TagService tagService;

    @GetMapping("hot")
    public Result hot() {
        int limit = 6;
        return tagService.hots(6);

    }


}
