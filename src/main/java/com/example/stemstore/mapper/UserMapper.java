package com.example.stemstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.stemstore.bean.Emp;
import com.example.stemstore.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_id=#{userId} and user_pwd=#{user_pwd}")
    List<User> select(@Param("userId") int userId, @Param("user_pwd") int user_pwd);

    @Insert("insert into user (user_name,user_pwd) values(#{userName},#{user_pwd});")
    int insert(@Param("userName") String userName, @Param("user_pwd") int user_pwd);

    @Select("select * from user where user_id=(select max(user_id) from user)")
    List<User> selectmaxid();
}
