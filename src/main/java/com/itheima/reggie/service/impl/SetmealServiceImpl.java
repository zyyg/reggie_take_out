package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.dto.SetmealDto;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import com.itheima.reggie.mapper.SetmealMapper;
import com.itheima.reggie.service.SetmealDishService;
import com.itheima.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yyzhou
 * @Date 2024/6/11 16:04
 * @PackageName:com.itheima.reggie.service.impl
 * @ClassName: SetmealServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Slf4j
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;
    /**
     * 新增套餐同时保存菜品的关联关系
     * @param setmealDto
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
       //保存套餐的基本信息，操作setmeal，执行insert操作
       this.save(setmealDto);
       List<SetmealDish> setmealDishes=setmealDto.getSetmealDishes();

       setmealDishes.stream().map((item)->{
           item.setSetmealId(setmealDto.getId());
           return item;
       }).collect(Collectors.toList());

       //保存套餐和菜品的关联信息，操作setmeal_dish
       setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐和菜品关联关系
     * @param ids
     */
    @Transactional
    public void deleteWithDish(List<Long> ids) {

       //查询套餐状态，确定是否可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        int count =this.count(queryWrapper);
        //如果不能删除，抛出业务异常
        if(count>0){
            throw new CustomException("套餐正在售卖中，不能删除");
        }
        //如果可以删除，先删除套餐表中的数据
        this.removeByIds(ids);
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(lambdaQueryWrapper);
       //删除关系表的数据
    }

}
