package com.example.stemstore.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.stemstore.bean.User;
import com.example.stemstore.mapper.UserMapper;
import com.example.stemstore.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
   public Map<String, Object> getUserInfo(int userId,int user_pwd)
    {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        //获取数据访问层的信息
        list = userMapper.select(userId,user_pwd);
        CollectionUtils.isNotEmpty(list);

        if (list.size()==1) {
            map.put("code", 1);
            map.put("message", "数据查询成功！");
            map.put("username", list.get(0).getUserName());
        } else {
            map.put("code",0);
            map.put("message", "数据查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> getUserstatus(int userId,int user_pwd)
    {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        //获取数据访问层的信息
        list = userMapper.select(userId,user_pwd);
        CollectionUtils.isNotEmpty(list);

        if (list.size()==1) {
            map.put("code", 1);
            map.put("message", "数据查询成功！");
        } else {
            map.put("code",0);
            map.put("message", "数据查询失败！");
        }
        return map;
    }

    @Override
    public Map<String, Object> registerUser(String userName,int user_pwd)
    {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        //获取数据访问层的信息
        userMapper.insert(userName,user_pwd);
        list = userMapper.selectmaxid();
        CollectionUtils.isNotEmpty(list);
        map.put("code", 1);
        map.put("user_id", list.get(0).getid());
        map.put("message", "注册成功");
        return map;

    }

}
