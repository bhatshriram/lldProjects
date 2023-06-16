package com.lld.bookmyshow.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends BaseModel{

    private List<Theatre> theatres;
    private String name;
}