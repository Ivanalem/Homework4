package com.academy;

import com.academy.entity.Passenger;
import com.academy.model.dao.PassengerDao;
import com.academy.model.dao.PersonalDao;
import com.academy.model.dao.RouteDao;
import com.academy.model.dao.TicketDao;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        PassengerDao passengerDao = new PassengerDao();

        List<Passenger> passengers = passengerDao.findAll();
        System.out.println(passengers);

        Passenger passenger1 = new Passenger();
        passenger1.setName("Anton");
        passenger1.setPassport("MP55432");
        passenger1.setEmail("anton@gmail.com");

        passengerDao.create(passenger1);
        passengerDao.findAll();

        PersonalDao personalDao = new PersonalDao();

        personalDao.findAll();

        RouteDao routeDao = new RouteDao();
        routeDao.findAll();

        TicketDao ticketDao = new TicketDao();
        ticketDao.findAll();


    }
}