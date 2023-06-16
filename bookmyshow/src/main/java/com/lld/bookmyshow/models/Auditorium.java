package com.lld.bookmyshow.models;


import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
