package com.example.stemstore.controller;

import com.example.stemstore.bean.Collect;
import com.example.stemstore.service.CollectService;
import com.example.stemstore.service.impl.CollectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title CollectionController
 * @Author X.H    @Date 2021/7/5 19:05
 * @Return
 */
@CrossOrigin
@RestController
public class CollectionController {

    @Resource
    CollectService collectService;

    //查询用户愿望清单
    @RequestMapping("/queryCollects")
    public Map<String,Object> queryCollect(@RequestParam(value = "userId") String userId){
        HashMap map = new HashMap();
        List games = collectService.queryCollect(Long.parseLong(userId));
        if (games.size()==0){
            map.put("code",1);
            map.put("message","此用户暂时未添加收藏");
        } else {
            map.put("code",1);
            map.put("games",games);
        }
        return map;
    }


    //添加用户愿望清单
    @RequestMapping("addCollect")
    public Map<String,Object> addCollect(@RequestParam(value = "userId") String userId,@RequestParam("gameId") String gameId){
        HashMap map = new HashMap();
        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(userId));
        collect.setGameId(Integer.parseInt(gameId));
        int exit = collectService.queryCollectByUserIdAndGameId(collect);
        if (exit==0 && collectService.addCollect(collect)>0){
            map.put("code",1);
            map.put("message","添加成功");

        }else {
            map.put("message","已存在，无需再添加");
            map.put("code",0);
        }
        return map;
    }
    @RequestMapping("/removeCollect" )
    public Map<String,Integer> removeCollect(@RequestParam(value = "userId") String userId,@RequestParam("gameId") String gameId){
        HashMap map = new HashMap();
        Collect collect = new Collect();
        collect.setUserId(Integer.parseInt(userId));
        collect.setGameId(Integer.parseInt(gameId));

        int code = collectService.removeCollect(collect);
        map.put("code",code);
        return map;
    }


}
