package com.qfedu.mitaole.dao;

import com.qfedu.mitaole.bean.Information;
import com.qfedu.mitaole.bean.TbAttr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AttrDao {

    TbAttr selectAll(Integer attrId);

    List<Information> selectAllMessage(@Param("disPhoneId")Integer disPhoneId, @Param("attrId")Integer attrId);


}
