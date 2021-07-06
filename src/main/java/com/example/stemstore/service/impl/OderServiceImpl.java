package com.example.stemstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.stemstore.bean.Odr;
import com.example.stemstore.mapper.OdrMapper;
import com.example.stemstore.service.OderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service

public class OderServiceImpl implements OderService {

    @Resource
    OdrMapper odrMapper;

    @Transactional
    @Override
    public int submitOrderByUGO(Odr odr) {
        /*根据数据库操作返回至判断submitStat其中1为插入成功，0失败*/
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",odr.getUserId());
        queryWrapper.eq("game_id",odr.getGameId());
        try {
            if (odrMapper.selectList(queryWrapper).size()==0){
                return odrMapper.insert(odr);
            }else{
                odrMapper.delete(queryWrapper);
                return odrMapper.insert(odr);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Transactional
    @Override
    public int removeOrderByorderNum(Long orderNum) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("order_num",orderNum);
        /*根据数据库操作返回至判断rmStatas其中1为删除成功，0失败*/
        try {
            return odrMapper.delete(queryWrapper);
        } catch (Exception e) {
            return 0;
        }
    }
}
