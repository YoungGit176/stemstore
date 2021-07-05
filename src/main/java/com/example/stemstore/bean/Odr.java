package com.example.stemstore.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor

public class Odr {
    @TableId(value = "order_num",type = IdType.AUTO)
    private Long orderNum;
    private Date orderDate;
    private int orderStat;
    private int userId;
    private int gameId;
    @TableField(exist = false)
//    @TableLogic
    private int logic;
}
