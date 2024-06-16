package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Orders;

/**
 * @Author yyzhou
 * @Date 2024/6/16 12:40
 * @PackageName:com.itheima.reggie.service
 * @ClassName: OrderService
 * @Description: TODO
 * @Version 1.0
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
