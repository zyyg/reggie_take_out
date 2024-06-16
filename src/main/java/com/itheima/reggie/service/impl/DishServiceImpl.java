package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.dto.DishDto;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import com.itheima.reggie.mapper.DishMapper;
import com.itheima.reggie.service.DishFlavorService;
import com.itheima.reggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yyzhou
 * @Date 2024/6/11 16:06
 * @PackageName:com.itheima.reggie.service.impl
 * @ClassName: DishServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;
    /**
     * 新增菜品，同时保存对应的口味信息
     * @param dishDto
     */
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);

        long dishId=dishDto.getId();
        //菜品口味
        List<DishFlavor> flavors=dishDto.getFlavors();

        flavors=flavors.stream().map((item)->{
           item.setDishId(dishId);
           return item;
        }).collect(Collectors.toList());
        //保存菜品口味数据到菜品口味表dish_dto
        dishFlavorService.saveBatch(flavors);
    }

    //根据id来查询菜品信息和口味信息
    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品基本信息

        Dish dish = this.getById(id);
        DishDto dishDto=new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //查询菜品的口味信息
        LambdaQueryWrapper<DishFlavor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());

        List<DishFlavor> flavors=dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);
        return dishDto;
    }

    @Transactional
    public void updateWithFlavor(DishDto dishDto) {

        //更新菜品表
        this.updateById(dishDto);

        //先清理当前提交过来的口味数据
        LambdaQueryWrapper<DishFlavor> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        //添加当前提交过来的口味数据
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors=flavors.stream().map((item)->{
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }
}
