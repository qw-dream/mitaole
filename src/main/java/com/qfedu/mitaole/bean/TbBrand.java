package com.qfedu.mitaole.bean;

import java.io.Serializable;

/**
 * (TbBrand)实体类
 *
 * @author makejava
 * @since 2020-07-07 20:49:46
 */
public class TbBrand implements Serializable {
    private static final long serialVersionUID = 553791086228553290L;
    
    private Integer brandId;
    
    private String brandName;


    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "TbBrand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}