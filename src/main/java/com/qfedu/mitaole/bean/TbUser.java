package com.qfedu.mitaole.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser {

  private Integer userId;
  private String userName;
  private String userPassword;
  private String userTel;
  private String salt;
  private String userAddress;


}
