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
    public Map<String, Object> login(@Param(value = "userId") int userId, @Param(value = "user_pwd") int user_pwd) {
        return this.userService.getUserInfo(userId,user_pwd);
    }
}
