package com.example.stemstore.controller;

import com.example.stemstore.bean.Odr;
import com.example.stemstore.service.OderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class OdersController {

    @Resource
    OderService oderService;

    /*查询用户订单*/
    @RequestMapping("/queryOrders")
    public List<Odr>queryOrders(@RequestParam(value = "userID") String userID){

        return oderService.queryOrdersByUserID(Long.parseLong(userID));
    }

    /*提交订单*/
    @RequestMapping("/submitOrder")
    public int submitOrder(Odr odr){
        odr.setOrderDate(new Date());
        return oderService.submitOrderByUGO(odr);
    }

    /*移除订单*/
    @RequestMapping("/removeOrder")
    public int removeOrder(@RequestParam(value = "orderID") String orderID){
        return oderService.removeOrderByorderNum(Long.parseLong(orderID));
    }
}
