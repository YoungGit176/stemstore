package com.example.stemstore.service;

import com.example.stemstore.bean.User;


import java.util.Map;

public interface UserService {
    Map<String, Object> getUserInfo(int userId,String user_pwd);

    Map<String, Object> getUserstatus(int userId,String user_pwd);

    Map<String, Object> registerUser(String userName,String user_pwd);
}
