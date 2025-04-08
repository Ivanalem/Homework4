package com.academy.model.dao;


import com.academy.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {

    public void create(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into route(classType,passport) values (?,?)");
            preparedStatement.setString(1, ticket.getClassType());
            preparedStatement.setString(2, ticket.getPassport());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update route set classType = ?, passport = ?, where id = ?");
            preparedStatement.setString(1, ticket.getClassType());
            preparedStatement.setString(2, ticket.getPassport());
            preparedStatement.setInt(3, ticket.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Ticket ticket) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from route where id = ?");
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select route.Id," +
                    " passanger.Id,personal.id,luggage.id  FROM ticket \n" +
                    "INNER join route ON ticket.routeId = route.id\n" +
                    "INNER join passanger ON ticket.passangerId = passanger.id\n" +
                    "INNER join personal ON ticket.personalId = personal.id\n" +
                    "INNER join luggage ON ticket.luggageId = luggage.id;");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Ticket> ticket = new ArrayList<>();
            while (resultSet.next()) {
                Ticket ticket1 = new Ticket();
                ticket1.setId(resultSet.getInt("id"));
                ticket1.setId(resultSet.getInt("routId"));
                ticket1.setPassport(resultSet.getString("passport"));
                ticket1.setPersonalId(resultSet.getInt("personalId"));
                ticket1.setClassType(resultSet.getString("classType"));
                ticket1.setId(resultSet.getInt("luggageId"));
                ticket.add(ticket1);
            }
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
