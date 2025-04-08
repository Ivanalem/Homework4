package com.academy.model.dao;

import com.academy.entity.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDao {

    public void create(Passenger passenger) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into passanger(name,email,passport) values (?,?,?)");
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getEmail());
            preparedStatement.setString(3, passenger.getPassport());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Passenger passenger) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update passanger set name = ?, email = ?, passport = ? where id = ?");
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getEmail());
            preparedStatement.setString(3, passenger.getPassport());
            preparedStatement.setInt(4, passenger.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Passenger passenger) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from passanger where id = ?");
            preparedStatement.setInt(1, passenger.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passenger> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from passanger");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Passenger> passengers = new ArrayList<>();
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getInt("id"));
                passenger.setName(resultSet.getString("name"));
                passenger.setEmail(resultSet.getString("email"));
                passenger.setPassport(resultSet.getString("passport"));
                passengers.add(passenger);
            }
            return passengers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Passenger findById(Integer id) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from passanger where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Passenger> passengers = new ArrayList<>();
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setId(resultSet.getInt("id"));
                passenger.setName(resultSet.getString("name"));
                passenger.setEmail(resultSet.getString("email"));
                passenger.setPassport(resultSet.getString("passport"));

                passengers.add(passenger);
            }
            return passengers.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
