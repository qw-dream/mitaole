package com.qfedu.mitaole.service.impl;

import com.qfedu.mitaole.bean.TbCategory;
import com.qfedu.mitaole.dao.CategoryDao;
import com.qfedu.mitaole.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<TbCategory> CategoryName() throws Exception {
        List<TbCategory> userNames = categoryDao.selectAllUserName();
        return userNames;
    }

}