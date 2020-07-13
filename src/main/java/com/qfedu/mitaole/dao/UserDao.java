package com.qfedu.mitaole.dao;

import com.qfedu.mitaole.bean.TbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    TbUser selectUserByName(String username) throws Exception;

    void addTbUser(TbUser user) throws Exception;
}
