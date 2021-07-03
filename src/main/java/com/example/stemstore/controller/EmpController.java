package com.example.stemstore.controller;

import com.example.stemstore.bean.Emp;
import com.example.stemstore.service.EmpService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 控制层
 */
@CrossOrigin
@RestController
public class EmpController {
    //依赖注入
    @Resource
    private EmpService empService;

    @RequestMapping("/redis")
    public Map<String, Object> method(Emp emp) {
        return this.empService.getEmpInfo(emp);
    }
}
