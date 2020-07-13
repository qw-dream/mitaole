package com.qfedu.mitaole.service;

import com.qfedu.mitaole.bean.TbUser;

public interface IUserService {

    public TbUser login(String username , String password) throws Exception;

    public void addTbUser(TbUser user) throws Exception;

}
