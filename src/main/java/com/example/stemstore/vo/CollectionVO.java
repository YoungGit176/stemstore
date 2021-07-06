package com.example.stemstore.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Title collection
 * @Author X.H    @Date 2021/7/5 19:37
 * @Return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CollectionVO {
    private int userId;

    @TableField(value = "game_id")
    private int gameId;

    @TableField(value = "game_name")
    private String gameName;
    @TableField(value = "game_price")
    private int gamePrice;

    @TableField(value = "gameIntro")
    private String gameIntro;

    @TableField(exist = false)
    private int logic;

}
