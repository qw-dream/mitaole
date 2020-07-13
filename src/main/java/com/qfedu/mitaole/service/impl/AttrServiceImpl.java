package com.qfedu.mitaole.service.impl;

import com.qfedu.mitaole.bean.Information;
import com.qfedu.mitaole.bean.TbAttr;
import com.qfedu.mitaole.dao.AttrDao;
import com.qfedu.mitaole.service.IAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttrServiceImpl implements IAttrService {

    @Autowired
    private AttrDao attrDao;

    //第一步评估
    @Override
    public List<TbAttr> selectAllMessage(Integer phoneId) throws Exception {
        List<TbAttr> attrList = new ArrayList<>();

        //属性 1~6 为第一步评估（固定）
        for (int i = 1; i < 7; i++) {
            //根据属性id查询对应属性对象
            TbAttr tbAttr = attrDao.selectAll(i);
            //三表查询，条件为手机id，属性id
            List<Information> information = attrDao.selectAllMessage(phoneId, i);
            tbAttr.setInformation(information);

            attrList.add(tbAttr);
        }
        return attrList;

    }

    //第二步评估
    @Override
    public TbAttr selectAllMessage1(Integer phoneId) throws Exception {
        //根据属性id查询对应属性对象
        TbAttr tbAttr = attrDao.selectAll(7);
        List<Information> information = attrDao.selectAllMessage(phoneId, 7);
        tbAttr.setInformation(information);


        return tbAttr;

    }

    //第三步评估
    @Override
    public List<TbAttr> selectAllMessage2(Integer phoneId) throws Exception {
        List<TbAttr> List = new ArrayList<>();
        //属性 1~6 为第一步评估（固定）
        for (int i = 8; i < 13; i++) {
            //根据属性id查询对应属性对象
            TbAttr tbAttr = attrDao.selectAll(i);
            //三表查询，条件为手机id，属性id
            List<Information> information = attrDao.selectAllMessage(phoneId, i);
            tbAttr.setInformation(information);

            List.add(tbAttr);
        }

        return List;
    }


}