package com.itheima.reggie.dto;

import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

/**
 * @Author yyzhou
 * @Date 2024/6/13 16:42
 * @PackageName:com.itheima.reggie.dto
 * @ClassName: SetmealDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
