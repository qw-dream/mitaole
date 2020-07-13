package com.qfedu.mitaole.dao;

import com.qfedu.mitaole.bean.TbCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

    List<TbCategory> selectAllUserName() throws Exception;

}
