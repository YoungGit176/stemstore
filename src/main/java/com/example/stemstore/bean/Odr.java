package com.example.stemstore.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor

public class Odr implements Serializable {

    private static final long serialVersionUID = 7467425116583468282L;
    @TableId(value = "order_num",type = IdType.AUTO)
    private Long orderNum;
    private Date orderDate;
    private int orderStat;
    private int userId;
    private int gameId;
    @TableField(exist = false)
    private String gameName;
    @TableField(exist = false)
//    @TableLogic
    private int logic;
}
