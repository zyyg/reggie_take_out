package com.itheima.reggie.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author yyzhou
 * @Date 2024/6/16 12:36
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: OrderDetail
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    //名称
    private String name;

    //订单id
    private Long orderId;


    //菜品id
    private Long dishId;


    //套餐id
    private Long setmealId;


    //口味
    private String dishFlavor;


    //数量
    private Integer number;

    //金额
    private BigDecimal amount;

    //图片
    private String image;
}
