package com.example.stemstore.service;

import com.example.stemstore.bean.User;


import java.util.Map;

public interface UserService {
    Map<String, Object> getUserInfo(int userId,int user_pwd);
}
