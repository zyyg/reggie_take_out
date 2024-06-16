package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/5/25 16:03
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: EmployeeMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
