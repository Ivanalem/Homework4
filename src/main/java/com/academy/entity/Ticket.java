package com.academy.entity;

import lombok.Data;

@Data
public class Ticket {

    private Integer id;
    private Route route;
    private Passenger passenger;
    private Personal personal;
    private String passport;
    private String classType;
    private Luggage luggage;
}
