package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author yyzhou
 * @Date 2024/6/11 22:32
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: DishFlavor
 * @Description: 菜品口味
 * @Version 1.0
 */
@Data
public class DishFlavor implements Serializable {

    private static final long serialVersionUID=1L;

    private long id;

    private long dishId;//菜品id

    private String name;//口味名称

    private String value;//口味数据list

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private long updateUser;

    private Integer isDeleted;//是否删除

}
