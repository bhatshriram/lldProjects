package com.lld.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{

  private  String name;
  private int age;
  private String email;
  private int phoneNumber;
  private String password;

}
