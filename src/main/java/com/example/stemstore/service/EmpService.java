package com.example.stemstore.service;

import com.example.stemstore.bean.Emp;

import java.util.Map;

public interface EmpService {
    //查询信息:演示使用Redis作为数据缓存
    Map<String, Object> getEmpInfo(Emp emp);
}
