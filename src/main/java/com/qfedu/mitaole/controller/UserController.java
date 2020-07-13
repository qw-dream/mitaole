package com.qfedu.mitaole.controller;

import com.qfedu.mitaole.JsonResult;
import com.qfedu.mitaole.QfConstant;
import com.qfedu.mitaole.bean.TbUser;
import com.qfedu.mitaole.exception.UnkownUsernameException;
import com.qfedu.mitaole.service.IUserService;
import com.qfedu.mitaole.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session) {
        TbUser user = null;
        JsonResult jsonResult = new JsonResult();
        try {
            user = userService.login(username,password);
            jsonResult.setCode(QfConstant.ViewCode.LOGIN_SUCCESS_CODE);
            jsonResult.setObj("phone/brand");

            session.setAttribute("user",user);
        } catch (UnkownUsernameException e) {
            e.printStackTrace();
            jsonResult.setCode(QfConstant.ViewCode.LOGIN_FAIL_CODE);
            jsonResult.setObj("用户名不存在，请注册");
        }catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(QfConstant.ViewCode.LOGIN_FAIL_CODE);
            jsonResult.setObj("用户名或密码错误");
        }
        return jsonResult;
    }


    @RequestMapping("register")
    @ResponseBody
    public JsonResult register(@RequestBody TbUser user){
        user.setSalt("mtl");
        String md5 = MD5Utils.md5(user.getUserPassword(), user.getSalt());
        user.setUserPassword(md5);

        JsonResult jsonResult = new JsonResult();

        try {
            userService.addTbUser(user);
            jsonResult.setCode(QfConstant.ViewCode.LOGIN_SUCCESS_CODE);
            jsonResult.setObj("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(QfConstant.ViewCode.LOGIN_FAIL_CODE);
            jsonResult.setObj("注册失败，请稍后再试");
        }
        return jsonResult;
    }

}