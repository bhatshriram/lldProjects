package com.lld.bookmyshow.models;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket extends BaseModel{
  private int amount;
  private Date timeOfBooking;
  private List<Seat> seats;

  private String bookedBy;

  private Show show;

  private List<Payment> payments;

  private TicketStatus ticketStatus;




}
