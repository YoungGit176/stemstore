package com.example.stemstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.stemstore.bean.Odr;
import com.example.stemstore.mapper.OdrMapper;
import com.example.stemstore.service.OderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service

public class OderServiceImpl implements OderService {

    @Resource
    OdrMapper odrMapper;

    @Override
    public int submitOrderByUGO(Odr odr) {
        /*根据数据库操作返回至判断submitStat其中1为插入成功，0失败*/
        return odrMapper.insert(odr);
    }

    @Override
    public int removeOrderByorderNum(Long orderNum) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("order_num",orderNum);
        /*根据数据库操作返回至判断rmStatas其中1为删除成功，0失败*/
        return odrMapper.delete(queryWrapper);
    }
}
