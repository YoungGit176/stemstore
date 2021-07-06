package com.example.stemstore.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int userId;
    private String userName;
    private int user_pwd;
    @TableField(exist = false)
    private int logic;

    public int getid(){
        return userId;
    }
    public int getpwd(){
        return user_pwd;
    }
    public String getUserName(){
        return userName;
    }
}
