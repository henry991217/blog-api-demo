package com.blog.blogapidemo.Service.impl;

import com.blog.blogapidemo.Mapper.SysUserMapper;
import com.blog.blogapidemo.Pojo.SysUser;
import com.blog.blogapidemo.Service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImp implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if(sysUser==null)
        {
            sysUser=new SysUser();
            sysUser.setNickname("Henry");
        }
//        空指针判断
        return sysUser;
    }

}
