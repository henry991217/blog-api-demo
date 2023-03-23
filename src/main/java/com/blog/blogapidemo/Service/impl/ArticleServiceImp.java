package com.blog.blogapidemo.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogapidemo.Mapper.ArticleMapper;
import com.blog.blogapidemo.Pojo.Article;
import com.blog.blogapidemo.Service.ArticleService;
import com.blog.blogapidemo.Vo.ArticleVo;
import com.blog.blogapidemo.Vo.Params.PageParams;
import com.blog.blogapidemo.Vo.Result;
import org.joda.time.DateTime;
import org.mybatis.spring.annotation.MapperScans;
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


    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page=new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        //查询返回weight置顶排序，日期排序
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
          //分页放入select方法中
        List<Article> records=articlePage.getRecords();
        //因为不是表中所有数据都需要，所以需要用vo对象封装再返回
        List<ArticleVo> articleVoList=copyList(records);
        //通过copy方法用vo对象封装
        return Result.success(articleVoList);

    }

    private List<ArticleVo> copyList(List<Article> records) {

        List<ArticleVo> articleVoList= new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record));
        }
        return  articleVoList;

        }

    //将article属性复制并转为articlevo
    private  ArticleVo copy(Article article)
    {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }


}
