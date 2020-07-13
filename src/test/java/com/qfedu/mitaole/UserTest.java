package com.qfedu.mitaole;

import com.github.pagehelper.PageInfo;
import com.qfedu.mitaole.bean.*;
import com.qfedu.mitaole.dao.AttrDao;
import com.qfedu.mitaole.dao.CategoryDao;
import com.qfedu.mitaole.dao.UserDao;
import com.qfedu.mitaole.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UserTest {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBrandService brandService;

    @Autowired
    private IPhoneService phoneService;

    @Autowired
    private AttrDao attrDao;

    @Autowired
    private IAttrService attrService;

    @Test
    public void testCase9() throws Exception {
        List<Information> allMessage = attrDao.selectAllMessage(1, 1);
        System.out.println(allMessage);
    }

    @Test
    public void testCase11() throws Exception {
        List<TbAttr> attrList = attrService.selectAllMessage(1);
        System.out.println(attrList);
    }

    @Test
    public void testCase13() throws Exception {
        TbAttr tbAttr = attrService.selectAllMessage1(1);
        System.out.println(tbAttr);
    }


    @Test
    public void testCase10() throws Exception {
        TbAttr tbAttr = attrDao.selectAll(1);
        System.out.println(tbAttr);
    }


    @Test
    public void testCase7() throws Exception {
        PageInfo<TbPhone> tbPhones = phoneService.AllPhone(1);
        System.out.println(tbPhones);

    }

    @Test
    public void testCase8() throws Exception {
        PageInfo<TbPhone> tbPhones = phoneService.ByBrandIdPhone(1,1);
        System.out.println(tbPhones);

    }


    @Test
    public void testCase6() throws Exception {
        List<TbBrand> tbBrands = brandService.BrandName();

    }

    @Test
    public void testCase5(){
        try {
            categoryService.CategoryName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase4(){
        try {
            List<TbCategory> tbCategories = categoryDao.selectAllUserName();
            System.out.println(tbCategories);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase3(){
        try {
            TbUser user = userDao.selectUserByName("qw5555");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCase1(){
        try {
            TbUser user1 = userService.login("dream","112233");
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase12() throws Exception {

        TbUser user = new TbUser();
        user.setUserName("dream");
        user.setUserPassword("112233");
        user.setUserAddress("武汉市江夏区腾花花大道35号腾翔花园");
        user.setUserTel("13866665555");

        userDao.addTbUser(user);
    }

}