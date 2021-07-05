package com.example.stemstore.service;

import com.example.stemstore.bean.Game;

import java.util.List;

public interface ShowGamesService {
    /*根据游戏名搜索游戏信息并且返回*/
    List<Game>searchGameByName(String name);
}
