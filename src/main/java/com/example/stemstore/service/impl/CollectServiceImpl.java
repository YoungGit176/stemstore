package com.example.stemstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.stemstore.bean.Collect;
import com.example.stemstore.mapper.CollectMapper;
import com.example.stemstore.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title CollectServiceImpl
 * @Author X.H    @Date 2021/7/5 19:10
 * @Return
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    CollectMapper collectMapper;

    @Override
    public List queryCollect(Long userID) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_Id",userID);
        return collectMapper.queryCollectByUserId(queryWrapper);
    }

    @Override
    public int addCollect(Collect collect) {
        return collectMapper.insert(collect);
    }

    @Override
    public int queryCollectByUserIdAndGameId(Collect collect) {
        QueryWrapper queryWrapper=new QueryWrapper();

        queryWrapper.eq("user_id",collect.getUserId());
        queryWrapper.eq("game_id",collect.getGameId());
        return collectMapper.selectCount(queryWrapper);
    }

    @Override
    public int removeCollect(Collect collect) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_id",collect.getUserId());
        updateWrapper.eq("game_id",collect.getGameId());
        return collectMapper.delete(updateWrapper);
    }
}
