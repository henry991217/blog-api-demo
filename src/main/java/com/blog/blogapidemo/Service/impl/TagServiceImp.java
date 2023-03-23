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
import org.springframework.util.CollectionUtils;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
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


    /**
     * 根据标签所拥有文章数量排列取前limit个
     * @param limit
     * @return
     */
    @Override
    public Result hots(int limit) {

        List<Long> TagIds = tagMapper.findHotsTagIds(limit);
        if(CollectionUtils.isEmpty(TagIds)){
            return  Result.success(Collections.emptyList());
        }
        List<Tag> tagsByTagIds = tagMapper.findTagsByTagIds(TagIds);

        return Result.success(tagsByTagIds);
    }

}
