package com.qfedu.mitaole.dao;

import com.qfedu.mitaole.bean.TbBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao {

    List<TbBrand> selectAllBrandName();

}
