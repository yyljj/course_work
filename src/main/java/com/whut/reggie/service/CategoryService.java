package com.whut.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whut.reggie.pojo.Category;


public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
