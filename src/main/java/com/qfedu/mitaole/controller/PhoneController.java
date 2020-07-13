package com.qfedu.mitaole.controller;

import com.github.pagehelper.PageInfo;
import com.qfedu.mitaole.JsonResult;
import com.qfedu.mitaole.QfConstant;
import com.qfedu.mitaole.bean.TbAttr;
import com.qfedu.mitaole.bean.TbBrand;
import com.qfedu.mitaole.bean.TbCategory;
import com.qfedu.mitaole.bean.TbPhone;
import com.qfedu.mitaole.service.IAttrService;
import com.qfedu.mitaole.service.IBrandService;
import com.qfedu.mitaole.service.ICategoryService;
import com.qfedu.mitaole.service.IPhoneService;
import com.qfedu.mitaole.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("phone")
@Controller
public class PhoneController {

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPhoneService phoneService;

    @Autowired
    private IAttrService attrService;

    //手机折损后最终价
    private static Integer discount;


    @RequestMapping("brand")
    public String brandName(Model model, String brandId ,HttpServletRequest request){

        try {
            String currentPageStr = request.getParameter("currentPageStr");
            //调用方法，将当前页的，字符串值转换成Integer,没有传页数，默认第一页
            Integer currentPage = PageUtils.getPage(currentPageStr);

            if (brandId == null){
                PageInfo<TbPhone> phoneList = phoneService.AllPhone(currentPage);
                model.addAttribute("phoneList",phoneList);
            }else {
                Integer integer = Integer.valueOf(brandId);//获取品牌id

                PageInfo<TbPhone> phoneList = phoneService.ByBrandIdPhone(integer,currentPage);//根据品牌Id分页
                model.addAttribute("phoneList",phoneList);
            }

            List<TbCategory> categoryNames = categoryService.CategoryName();//分类搜索
            model.addAttribute("categoryNames",categoryNames);

            List<TbBrand> brandNames = brandService.BrandName();//手机品牌
            model.addAttribute("brandNames",brandNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }




    @RequestMapping("info")
    public String info(Model model, String phoneId){

        //获取手机Id,转换为Integer
        Integer phone = Integer.valueOf(phoneId);

        try {
            TbPhone tbPhone = phoneService.selectPhone(phone);
            model.addAttribute("tbPhone",tbPhone);

            List<TbAttr> attrList = attrService.selectAllMessage(phone);
            model.addAttribute("attrList",attrList);

            TbAttr tbAttr = attrService.selectAllMessage1(phone);
            model.addAttribute("tbAttr",tbAttr);

            List<TbAttr> attrList1 = attrService.selectAllMessage2(phone);
            model.addAttribute("attrList1",attrList1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "info";
    }

    @RequestMapping("info2")
    @ResponseBody
    public JsonResult info(@RequestBody Map<String, Object> key){

        JsonResult jsonResult = new JsonResult();

        try {
            //最终回收价
            discount = phoneService.selectDis(key);

            jsonResult.setCode(QfConstant.ViewCode.LOGIN_SUCCESS_CODE);
            jsonResult.setObj("phone/price");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    @RequestMapping("price")
    public String price(Model model){
        TbPhone tbPhone = new TbPhone();
        tbPhone.setPhonePrice(discount);

        model.addAttribute("tbPhone",tbPhone);

        return "price";
    }
}