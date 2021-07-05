package com.example.stemstore.service;


import com.example.stemstore.bean.Odr;
import java.util.List;

public interface OderService {
    /*根据userID获取用户所有订单*/
    List<Odr> queryOrdersByUserID(Long userId);
    /*提交Order订单*/
    int submitOrderByUGO(Odr odr);
    /*根据订单号更新订单*/
    int removeOrderByorderNum(Long orderNum);

}
