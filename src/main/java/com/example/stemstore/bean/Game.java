package com.example.stemstore.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @TableId(value = "game_id",type = IdType.AUTO)
    private Long gameId;
    private String gameName;
    private int gamePrice;
    private String gameIntro;
    @TableField(exist = false)
//    @TableLogic
    private int logic;
}
