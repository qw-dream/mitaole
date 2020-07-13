package com.qfedu.mitaole.service.impl;

import com.qfedu.mitaole.bean.TbBrand;
import com.qfedu.mitaole.dao.BrandDao;
import com.qfedu.mitaole.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public List<TbBrand> BrandName() throws Exception {

        List<TbBrand> tbBrands = brandDao.selectAllBrandName();

        return tbBrands;
    }
}