package com.qfedu.mitaole.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.mitaole.bean.TbDiscount;
import com.qfedu.mitaole.bean.TbPhone;
import com.qfedu.mitaole.dao.PhoneDao;
import com.qfedu.mitaole.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private PhoneDao phoneDao;

    @Override
    public PageInfo<TbPhone> AllPhone(Integer currentPage) throws Exception {

        PageHelper.startPage(currentPage, 8);
        List<TbPhone> tbPhones = phoneDao.selectPhoneList();
        PageInfo<TbPhone> tbPhonePageInfo = new PageInfo<>(tbPhones);
        return tbPhonePageInfo;
    }

//        @Override
//    public PageInfo<TbPhone> AllPhone(Integer brandId, Integer currentPage) throws Exception {
//
//        PageHelper.startPage(currentPage, 8);
//        List<TbPhone> tbPhones = phoneDao.selectByBrandIdPhone(brandId);
//        PageInfo<TbPhone> tbPhonePageInfo = new PageInfo<>(tbPhones);
//
//        return tbPhonePageInfo;
//    }

    @Override
    public PageInfo<TbPhone> ByBrandIdPhone(Integer brandId, Integer currentPage) throws Exception {

        PageHelper.startPage(currentPage, 8);
        List<TbPhone> tbPhones = phoneDao.selectByBrandIdPhone(brandId);
        PageInfo<TbPhone> tbPhonePageInfo = new PageInfo<>(tbPhones);

        return tbPhonePageInfo;
    }

    @Override
    public TbPhone selectPhone(Integer phoneId) throws Exception {
        TbPhone tbPhone = phoneDao.selectPhone(phoneId);
        return tbPhone;
    }

    @Override
    public Integer selectDis(Map<String, Object> key) throws Exception {
        //最终折损价
        Integer num = 0;
        //手机Id
        Integer phoneId = 0;
        //取到key中的集合
        for (String dis : key.keySet()) {
            List<Integer> dis1 = (ArrayList<Integer>) key.get(dis);
            //下标0为手机Id
            phoneId = dis1.get(0);
            //遍历集合，拿到（折损价Id）
            for (int i = 1; i < dis1.size(); i++) {
                //判断是否为空
                if (dis1.get(i) != null){
                    //传入Id拿到折损价
                    TbDiscount discount = phoneDao.selectDis(dis1.get(i));
                    //所有折损价相加
                    num += discount.getDiscount();
                }
            }
        }

        TbPhone tbPhone = phoneDao.selectPhone(phoneId);
        //手机基础价
        Integer phonePrice = tbPhone.getPhonePrice();
        //最终价
        num = phonePrice - num;

        return num;
    }
}