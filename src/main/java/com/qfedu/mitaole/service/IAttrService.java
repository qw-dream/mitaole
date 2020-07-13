package com.qfedu.mitaole.service;

import com.qfedu.mitaole.bean.TbAttr;

import java.util.List;

public interface IAttrService {
    public List<TbAttr> selectAllMessage(Integer phoneId)throws Exception;

    public TbAttr selectAllMessage1(Integer phoneId) throws Exception;

    public List<TbAttr> selectAllMessage2(Integer phoneId) throws Exception;

}
