package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/11 16:01
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: DishMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface DishMapper  extends BaseMapper<Dish> {
}
