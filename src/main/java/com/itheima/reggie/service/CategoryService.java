package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * @Author yyzhou
 * @Date 2024/6/11 14:35
 * @PackageName:com.itheima.reggie.service
 * @ClassName: CategoryService
 * @Description: TODO
 * @Version 1.0
 */
public interface CategoryService  extends IService<Category> {

    public  void remove(Long id);
}
