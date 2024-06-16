package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/11 14:33
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: CategoryMapper
 * @Description: 数据库查询
 * @Version 1.0
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
