package com.qfedu.mitaole.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPhone {

  private Integer phoneId;
  private Integer brandId;
  private String phoneName;
  private Integer phonePrice;
  private Integer phoneCategoryId;
  private String phoneImg;
  private Integer goodFirstPrice;
  private Integer goodSecondPrice;
  private Integer goodThirdPrice;
  private Integer goodForthPrice;
  private Integer goodFifthPrice;


}
