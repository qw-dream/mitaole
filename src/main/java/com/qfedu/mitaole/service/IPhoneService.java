package com.qfedu.mitaole.service;

import com.github.pagehelper.PageInfo;
import com.qfedu.mitaole.bean.TbPhone;

import java.util.List;
import java.util.Map;

public interface IPhoneService {

    public PageInfo<TbPhone> AllPhone(Integer currentPageStr)throws Exception;

    public PageInfo<TbPhone> ByBrandIdPhone(Integer brandId,Integer currentPageStr)throws Exception;

    public TbPhone selectPhone(Integer phoneId)throws Exception;

    public Integer selectDis(Map<String, Object> key)throws Exception;

}
