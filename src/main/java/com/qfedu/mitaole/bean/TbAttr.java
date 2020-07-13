package com.qfedu.mitaole.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbAttr {

  private Integer attrId;
  private String attrName;
  private List<Information> information;

}
