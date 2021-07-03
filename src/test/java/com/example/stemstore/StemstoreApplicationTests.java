package com.example.stemstore;

import com.example.stemstore.bean.Emp;
import com.example.stemstore.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class StemstoreApplicationTests {
    //依赖注入：数据访问层的组件：API
    @Resource
    private EmpMapper empMapper;

    @Resource
    private Emp emp;

    @Test
    void contextLoads() {
    }

}
