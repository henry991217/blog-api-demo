package com.blog.blogapidemo.Service.impl;

import com.blog.blogapidemo.Mapper.TagMapper;
import com.blog.blogapidemo.Pojo.Article;
import com.blog.blogapidemo.Pojo.Tag;
import com.blog.blogapidemo.Service.TagService;
import com.blog.blogapidemo.Vo.ArticleVo;
import com.blog.blogapidemo.Vo.Result;
import com.blog.blogapidemo.Vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImp implements TagService {


    @Autowired
  private   TagMapper tagMapper;

    private List<TagVo> copyList(List<Tag> tags) {

        List<TagVo> tagsVoList= new ArrayList<>();
        for (Tag tag : tags) {
            tagsVoList.add(copy(tag));
        }
        return  tagsVoList;
    }
//返回tags对应封装属性列表
    private TagVo copy(Tag tag) {

        TagVo tagVo=new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    @Override
    public List<TagVo> findTagsByArticlesId(Long articleId) {

        List<Tag> tags=tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int i) {
        return null;
    }

}
