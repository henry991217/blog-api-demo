package com.blog.blogapidemo.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogapidemo.Mapper.ArticleMapper;
import com.blog.blogapidemo.Pojo.Article;
import com.blog.blogapidemo.Service.ArticleService;
import com.blog.blogapidemo.Service.SysUserService;
import com.blog.blogapidemo.Service.TagService;
import com.blog.blogapidemo.Vo.ArticleVo;
import com.blog.blogapidemo.Vo.Params.PageParams;
import com.blog.blogapidemo.Vo.Result;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {



    //展示文章列表
    @Autowired
    ArticleMapper articleMapper;
//    mp调用

    @Autowired
    TagService tagService;

    @Autowired
    SysUserService sysUserService;

    public Result listArticle(PageParams pageParams) {
        Page<Article> page=new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        //查询返回weight置顶排序，日期排序
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
          //分页放入select方法中
        List<Article> records=articlePage.getRecords();
        //因为不是表中所有数据都需要，所以需要用vo对象封装再返回
        List<ArticleVo> articleVoList=copyList(records, true,true);
        //通过copy方法用vo对象封装
        return Result.success(articleVoList);

    }

    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId, Article::getTitle);
        queryWrapper.last("limit "+limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false));
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isAuthor, boolean isTag) {

        List<ArticleVo> articleVoList= new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record,isTag,isAuthor));
        }
        return  articleVoList;

        }

    //将article属性复制并转为articlevo
    private  ArticleVo copy(Article article,boolean isTag,boolean isAuthor)
    {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));

        if(isTag)
        {
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticlesId(articleId));
        }
        if(isAuthor)
        {
            Long id = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(id).getNickname());
        }

        return articleVo;
    }



}
