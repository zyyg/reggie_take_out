package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/15 11:19
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: UserMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
