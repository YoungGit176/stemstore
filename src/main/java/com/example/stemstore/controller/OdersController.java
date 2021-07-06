package com.example.stemstore.controller;

import com.example.stemstore.bean.Odr;
import com.example.stemstore.mapper.OdrMapper;
import com.example.stemstore.service.OderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class OdersController {

    @Resource
    OderService oderService;

    @Resource
    OdrMapper odrMapper;

    /*查询用户订单*/
    @RequestMapping("/queryOrders")
    public List<Odr>queryOrders(@RequestParam(value = "userID") String userID){
        return odrMapper.selectOderAll(Long.parseLong(userID));
    }

    /*提交订单*/
    @RequestMapping("/submitOrder")
    public Map<String,Integer> submitOrder(Odr odr){
        Map<String,Integer> map=new HashMap<>();
        odr.setOrderDate(new Date());
        map.put("code",oderService.submitOrderByUGO(odr));
        return map;
    }

    /*移除订单*/
    @RequestMapping("/removeOrder")
    public Map<String,Integer> removeOrder(@RequestParam(value = "orderID") String orderID){
        Map<String,Integer> map=new HashMap<>();
        map.put("code",oderService.removeOrderByorderNum(Long.parseLong(orderID)));
        return map;
    }
}
