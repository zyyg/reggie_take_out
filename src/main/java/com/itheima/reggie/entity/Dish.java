package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author yyzhou
 * @Date 2024/6/11 15:52
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: Dish
 * @Description: 菜品
 * @Version 1.0
 */
@Data
public class Dish implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String name;//菜品名称

    private Long categoryId;//菜品分类id

    private BigDecimal price;//菜品价格

    private String code;//商品码

    private String image;//图片

    private String description;//描述信息

    private Integer status;//0停售，1起售

    private Integer sort;//顺序

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
