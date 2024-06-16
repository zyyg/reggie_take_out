package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author yyzhou
 * @Date 2024/6/11 15:56
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: Setmeal
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class Setmeal implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;

    private Long categoryId;//分类Id

    private String name;//套餐名称

    private BigDecimal price;//套餐价格

    private Integer status;//0停用，1启用

    private String code;//编码

    private String description;//描述信息

    private String image;//图片

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
