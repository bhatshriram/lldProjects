package com.lld.bookmyshow.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show extends BaseModel{

  private Auditorium auditorium;
  private Date startTime;
  private Date endTime;

  private Movie movie;
  private Language language;


}
