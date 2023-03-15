package com.blog.blogapidemo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blogapidemo.Pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
