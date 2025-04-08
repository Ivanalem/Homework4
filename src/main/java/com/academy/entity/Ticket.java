package com.academy.entity;

import lombok.Data;

@Data
public class Ticket {

    private Integer id;
    private Integer routId;
    private Integer passengerId;
    private String passport;
    private Integer personalId;
    private String classType;
    private Integer luggageId;
}
