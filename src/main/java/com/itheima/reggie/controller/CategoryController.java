package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yyzhou
 * @Date 2024/6/11 10:38
 * @PackageName:com.itheima.reggie.controller
 * @ClassName: CategoryController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
        @Autowired
        private CategoryService categoryService;

        /**
         * 新增分类
         * @param category
         * @return
         */
        @PostMapping
        private R<String> save(@RequestBody Category category){
                log.info("category:{}",category);
                categoryService.save(category);
                return R.success("新增分类成功");
        }

        @GetMapping("/page")
        public R<Page> page(int page, int pageSize){
                //分页构造器
                Page<Category> pageInfo=new Page<>(page,pageSize);
                //条件构造器
                LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper<>();
                //添加排序条件
                queryWrapper.orderByAsc(Category::getSort);
                //进行分页查询
                categoryService.page(pageInfo,queryWrapper);
                return R.success(pageInfo);
        }

        /**
         * 根据id删除分类
         */
        @DeleteMapping
        public R<String> delete(Long ids){
                log.info("删除分类：{}",ids);

//                categoryService.removeById(id);
                categoryService.remove(ids);
                return R.success("分类信息删除成功");
        }

        @PutMapping
        public R<String> update(@RequestBody Category category){
                log.info("修改分类信息：{}",category);
                categoryService.updateById(category);
                return null;
        }

        @GetMapping("/list")
        public R<List<Category>> list(Category category){
                LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper<>();

                queryWrapper.eq(category.getType()!=null,Category::getType,category.getType());

                queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

                List<Category> list=categoryService.list(queryWrapper);

                return R.success(list);
        }
}
