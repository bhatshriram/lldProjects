package com.lld.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Seat {

  private String seatNumber;
  private int row;
  private int col;
  private SeatType seatType;

}
