package com.example.stemstore;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.stemstore.bean.Emp;
import com.example.stemstore.bean.User;
import com.example.stemstore.controller.CollectionController;
import com.example.stemstore.controller.UserController;
import com.example.stemstore.mapper.CollectMapper;
import com.example.stemstore.mapper.EmpMapper;
import com.example.stemstore.mapper.UserMapper;
import com.example.stemstore.service.UserService;
import com.example.stemstore.vo.CollectionVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StemstoreApplicationTests {
    //依赖注入：数据访问层的组件：API
    @Resource
    private EmpMapper empMapper;
    @Resource
    private CollectMapper collectMapper;
    @Resource
    private CollectionController controller;

    @Resource
    private UserController userController;

    @Resource
    private Emp emp;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("test", "sad");
    }

    @Test
    void contextLoads2() {
        Object test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }

    @Test
    void testinsert() {
        int count = empMapper.insert(emp);
        System.out.println("count = " + count);
    }

    //删除：
    @Test
    void testdeleteById() {
        int count = empMapper.deleteById(emp);
        System.out.println("count = " + count);
    }

    //带条件删除：
    @Test
    void testdeleteQueryWrapper() {

        //创建条件构造器：
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deptno", 30);
        queryWrapper.ge("sal", 1000);
        queryWrapper.like("ename", "A");
        queryWrapper.or();
        queryWrapper.isNull("comm");
        //调用delete
        int count = empMapper.delete(queryWrapper);
        System.out.println("count = " + count);
    }
    @Test
    public void test(){
        System.out.println("测试");
    }

    @Test
    public void testQueryCollect(){
        QueryWrapper  queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",1001);
        List<CollectionVO> collectionVOS = collectMapper.queryCollectByUserId(queryWrapper);
        System.out.println(collectionVOS);
    }
    @Test
    public void testAddCollect(){
        Map<String, Object> map = controller.addCollect("1001", "2002");
        System.out.println(map);

    }

    @Test
    public void login(){
        Map<String, Object> map = userController.login(1001, 123456);
        System.out.println(map);

    }
}
