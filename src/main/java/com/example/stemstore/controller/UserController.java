package com.example.stemstore.controller;

import com.example.stemstore.bean.User;
import com.example.stemstore.service.UserService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public Map<String, Object> login(@Param(value = "userId") int userId, @Param(value = "user_pwd") String user_pwd) {
        return this.userService.getUserInfo(userId,user_pwd);
    }

    @RequestMapping("/logout")
    public Map<String, Object> logout(@Param(value = "userId") int userId, @Param(value = "user_pwd") String user_pwd) {
        return this.userService.getUserstatus(userId,user_pwd);
    }

    @RequestMapping("/register")
    public Map<String, Object> registerUser(@Param(value = "userName") String userName, @Param(value = "user_pwd") String user_pwd) {
        return this.userService.registerUser(userName,user_pwd);
    }
}
