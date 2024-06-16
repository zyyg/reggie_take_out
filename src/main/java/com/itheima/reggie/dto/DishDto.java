package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yyzhou
 * @Date 2024/6/11 23:21
 * @PackageName:com.itheima.reggie.dto
 * @ClassName: DishDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors=new ArrayList<>();

    private String  categoryName;

    private Integer copies;
    
}
