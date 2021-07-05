package com.example.stemstore.controller;

import com.example.stemstore.bean.Game;
import com.example.stemstore.mapper.GameMapper;
import com.example.stemstore.service.ShowGamesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
public class ShowGamesController {

    @Resource
    GameMapper gameMapper;

    @Resource
    ShowGamesService showGamesService;

    /*获得所有游戏信息*/
    @RequestMapping("/queryAllGames")
    public List<Game> queryAllGames(){
        return gameMapper.selectList(null);
    }


    /*返回用户搜索游戏信息*/
    @RequestMapping("/searchGame")
    public List<Game> searchGame(@RequestParam(value = "gameName") String gameName){
        return showGamesService.searchGameByName(gameName);
    }
}
