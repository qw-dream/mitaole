package com.qfedu.mitaole.dao;

import com.qfedu.mitaole.bean.TbDiscount;
import com.qfedu.mitaole.bean.TbPhone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhoneDao {

    TbPhone selectPhone(Integer phoneId);

    List<TbPhone> selectPhoneList();

    List<TbPhone> selectByBrandIdPhone(Integer brand);

    TbDiscount selectDis(Integer disId);

}
