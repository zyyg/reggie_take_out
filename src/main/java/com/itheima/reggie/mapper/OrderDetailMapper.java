package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.OrderDetail;
import com.itheima.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/16 12:39
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: OrderDetailMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
