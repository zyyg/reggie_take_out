package com.itheima.reggie.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yyzhou
 * @Date 2024/6/14 23:32
 * @PackageName:com.itheima.reggie.entity
 * @ClassName: User
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String name;//姓名

    private String phone;//手机号

    private String Sex;//性别0女 1男

    private String idNumber;//身份证号码

    private String avatar;//头像

    private Integer status;//0禁用1正常
}
