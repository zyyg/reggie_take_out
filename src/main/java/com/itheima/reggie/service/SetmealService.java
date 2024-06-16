package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;

import java.util.List;

/**
 * @Author yyzhou
 * @Date 2024/6/11 16:03
 * @PackageName:com.itheima.reggie.service
 * @ClassName: SetmealService
 * @Description: TODO
 * @Version 1.0
 */
public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐同时保存菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐和菜品关联关系
     * @param ids
     */
    public void deleteWithDish(List<Long> ids);
}
