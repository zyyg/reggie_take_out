package com.itheima.reggie.dto;

import com.itheima.reggie.entity.OrderDetail;
import com.itheima.reggie.entity.Orders;
import lombok.Data;

import java.util.List;

/**
 * @Author yyzhou
 * @Date 2024/6/16 19:17
 * @PackageName:com.itheima.reggie.dto
 * @ClassName: OrderDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class OrderDto extends Orders {
    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;

    private int sumNum;
}
