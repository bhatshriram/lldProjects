package com.lld.bookmyshow.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{

  private int amount;
  private PaymentProvider paymentProvider;
  private Date time;
  private String refId;

  private PaymentStatus paymentStatus;
  private PaymentType paymentType;

}
