package com.example.stemstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.stemstore.bean.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpMapper extends BaseMapper<Emp> {
    //查询信息
    @Select("select * from emp")
    List<Emp> select();
}
