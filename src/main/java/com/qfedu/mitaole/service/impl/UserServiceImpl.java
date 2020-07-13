package com.qfedu.mitaole.service.impl;

import com.qfedu.mitaole.bean.TbUser;
import com.qfedu.mitaole.dao.UserDao;
import com.qfedu.mitaole.exception.PasswordIncorrectException;
import com.qfedu.mitaole.exception.UnkownUsernameException;
import com.qfedu.mitaole.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qfedu.mitaole.service.IUserService;
import org.springframework.stereotype.Service;

//@Component
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public TbUser login(String username, String password) throws Exception {

        if ("".equals(username) || username == null){
            throw new UnkownUsernameException();
        }
        //校验用户名或者密码是否正确
        TbUser user = userDao.selectUserByName(username);
        if (user == null){
            throw new UnkownUsernameException();
        }
        //将用户传入的密码进行加密
        String md5 = MD5Utils.md5(password, user.getSalt());

        //校验密码
        if (!user.getUserPassword().equals(md5)){
            throw new PasswordIncorrectException();
        }

        return user;
    }

    @Override
    public void addTbUser(TbUser user) throws Exception {
        userDao.addTbUser(user);

    }
}