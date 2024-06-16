package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/16 12:38
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: OrderMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
