package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author yyzhou
 * @Date 2024/6/13 15:44
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: SetmealDish
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class SetmealDish implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;

    private Long setmealId;//套餐id

    private Long dishId;//菜品id

    private String name;//菜品名称（冗余字段）

    private BigDecimal price;//菜品价格

    private Integer copies;//份数

    private Integer sort;//排序

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private long updateUser;

    private Integer isDeleted;
}
