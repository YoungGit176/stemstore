package com.example.stemstore.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Title Collect
 * @Author X.H    @Date 2021/7/5 18:57
 * @Return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName(value = "coll")
public class Collect implements Serializable {
    private static final long serialVersionUID = 7588233133434675813L;
    @TableId(value = "user_id")
    private int userId;

    @TableField(value = "game_id")
    private int gameId;

    @TableField(exist = false)
    private int logic;

}
