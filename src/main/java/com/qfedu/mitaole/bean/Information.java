package com.qfedu.mitaole.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {

    private Integer attrId;     //属性id；
    private String attrName;        //属性名
    private Integer discountId;     //折损id
    private Integer disPhoneId;     //外键（手机）
    private Integer attrvalueId;        //外键（属性值）
    private Integer discount;       //折损价
    private Integer valId;      //属性值id
    private String valAttrVal;      //属性值
    private String valDesc;     //属性值隐藏内容
    private Integer valAttrId;      //外键（属性）

}