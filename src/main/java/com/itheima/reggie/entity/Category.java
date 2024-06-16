package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author yyzhou
 * @Date 2024/6/11 14:27
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: Category
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private Integer type;//类型1 菜品分类，类型2 套餐分类

    private String name;//分类名称

    private Integer sort;//排序字段

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;//更新时间

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;//创建人

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;//更新人

}
