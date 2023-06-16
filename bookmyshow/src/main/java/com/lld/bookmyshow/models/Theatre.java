package com.lld.bookmyshow.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre extends BaseModel{

  private  String name;
  private  String address;
  private List<Auditorium> auditoriums;
  private City city;
}
