package com.academy.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Route {
    private Integer id;
    private Airplane airplane;
    private Date arrivalTime;
    private Date departureTime;
    private Integer arrivalLocationId;
    private Integer departureLocationId;
}
