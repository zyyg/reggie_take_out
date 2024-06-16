package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author yyzhou
 * @Date 2024/6/15 10:52
 * @PackageName:com.itheima.reggie.mapper
 * @ClassName: AddressBookMapper
 * @Description: TODO
 * @Version 1.0
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
