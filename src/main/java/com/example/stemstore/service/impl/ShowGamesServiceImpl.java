package com.example.stemstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.stemstore.bean.Game;
import com.example.stemstore.mapper.GameMapper;
import com.example.stemstore.service.ShowGamesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShowGamesServiceImpl implements ShowGamesService {

    @Resource
    GameMapper gameMapper;


    @Override
    /*根据游戏名模糊查询并且返回所有匹配信息*/
    public List<Game> searchGameByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("game_name",name);
        return gameMapper.selectList(queryWrapper);
    }
}
