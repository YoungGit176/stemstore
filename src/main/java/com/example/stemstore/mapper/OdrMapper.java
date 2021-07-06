package com.example.stemstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.stemstore.bean.Odr;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OdrMapper extends BaseMapper<Odr> {
    /*根据用户id查询订单列表名单+game_name*/
    @Select("select order_num,order_date,order_stat,user_id,odr.game_id, game_name from odr left join game on odr.game_id = game.game_id where user_id=#{userID};")
    List<Odr>selectOderAll(Long userID);
}
