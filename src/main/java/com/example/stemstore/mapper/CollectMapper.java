package com.example.stemstore.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.stemstore.bean.Collect;
import com.example.stemstore.vo.CollectionVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {
    String sql="select c.user_id,g.game_id,game_name,game_price,game_intro " +
            "from coll c left join game g on c.game_id = g.game_id ${ew.customSqlSegment}";
    @Select(sql)
    List<CollectionVO> queryCollectByUserId(@Param(Constants.WRAPPER) Wrapper wrapper);
}
