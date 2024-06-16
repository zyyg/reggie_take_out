package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import com.itheima.reggie.dto.OrderDto;
import com.itheima.reggie.entity.OrderDetail;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.service.OrderDetailService;
import com.itheima.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yyzhou
 * @Date 2024/6/16 12:44
 * @PackageName:com.itheima.reggie.controller
 * @ClassName: OrderController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){

        orderService.submit(orders);
        return R.success("下单成功");
    }

    @GetMapping("/userPage")
    public R<Page> page(int page, int pageSize){
        Page<Orders> pageInfo=new Page<>();
        Page<OrderDto> orderDtoPage=new Page<>();

        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getUserId, BaseContext.getCurrentId());
        queryWrapper.orderByDesc(Orders::getCheckoutTime);

        orderService.page(pageInfo,queryWrapper);
        BeanUtils.copyProperties(pageInfo,orderDtoPage,"records");
        List<Orders> records = pageInfo.getRecords();
        List<OrderDto> list=records.stream().map((item)->{
            OrderDto orderDto=new OrderDto();
            BeanUtils.copyProperties(item,orderDto);
            Long orderId = item.getId();
            LambdaQueryWrapper<OrderDetail> orderDetailLambdaQueryWrapper=new LambdaQueryWrapper<>();
            orderDetailLambdaQueryWrapper.eq(OrderDetail::getId,orderId);

            List<OrderDetail> orderDetailList = orderDetailService.list(orderDetailLambdaQueryWrapper);
            orderDto.setOrderDetails(orderDetailList);
            orderDto.setSumNum(orderDetailList.size());
            return orderDto;
        }).collect(Collectors.toList());
        orderDtoPage.setRecords(list);
        return R.success(orderDtoPage);
    }
}
