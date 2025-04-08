package com.academy.model.dao;

import com.academy.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {

    public void create(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into route(arrivalTime,departureTime) values (?,?)");
            preparedStatement.setDate(1, route.getArrivalTime());
            preparedStatement.setDate(2, route.getDepartureTime());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update route set arrivalTime = ?, departureTime = ?, where id = ?");
            preparedStatement.setDate(1, route.getArrivalTime());
            preparedStatement.setDate(2, route.getDepartureTime());
            preparedStatement.setInt(3, route.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Route route) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from route where id = ?");
            preparedStatement.setInt(1, route.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Route> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM route;\n" +
                    "SELECT airplane.id, location.id FROM route\n" +
                    "INNER join airplane ON airplane.id = route.airplaneId\n" +
                    "INNER join location ON location.id = route.arrivalLocationId\n" +
                    "INNER join location ON location.id = route.departureLocationId;");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Route> route = new ArrayList<>();
            while (resultSet.next()) {
                Route route1 = new Route();
                route1.setId(resultSet.getInt("id"));
                route1.setId(resultSet.getInt("airplaneId"));
                route1.setArrivalTime(resultSet.getDate("arrivalTime"));
                route1.setDepartureTime(resultSet.getDate("departureTime"));
                route1.setId(resultSet.getInt("arrivalLocationId"));
                route1.setId(resultSet.getInt("departureLocationId"));
                route.add(route1);
            }
            return route;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
