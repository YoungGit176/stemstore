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
   public Map<String, Object> getUserInfo(int userId,String user_pwd)
    {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
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
    public Map<String, Object> getUserstatus(int userId,String user_pwd)
    {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
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
    public Map<String, Object> registerUser(String userName,String user_pwd)
    {
        int succ=0;
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
       list = userMapper.selectname(userName);
        CollectionUtils.isNotEmpty(list);
        if (list.size()==0) {
            succ = userMapper.insert(userName,user_pwd);
            list = userMapper.selectmaxid();
            map.put("code", succ);
            map.put("user_id", list.get(0).getid());
            map.put("message", "注册成功");
        }   else {
            map.put("code", succ);
            map.put("message", "注册失败");
        }

        return map;

    }

}
