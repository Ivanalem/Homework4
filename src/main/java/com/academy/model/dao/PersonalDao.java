package com.academy.model.dao;

import com.academy.entity.Airplane;
import com.academy.entity.AirplanePersonal;
import com.academy.entity.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalDao {

    public void create(Personal personal) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into personal(id,type) values (?,?)");
            preparedStatement.setInt(1, personal.getId());
            preparedStatement.setObject(2, personal.getType());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Personal personal) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update personal set id = ?, type = ? where id = ?");
            preparedStatement.setInt(1, personal.getId());
            preparedStatement.setObject(2, personal.getType());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Personal personal) {
        try {
            Connection connection = DataSource.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("delete from personal where id = ?");
            preparedStatement.setInt(1, personal.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> findAll() {
        try {
            Connection connection = DataSource.getInstance().getConnection();
            //Request for airplane_personal and select from personal information
            PreparedStatement preparedStatement = connection.prepareStatement("select * from personal; " +
                    "SELECT airplane.id, personal.id FROM airplane_personal\n" +
                    "INNER join airplane ON airplane.id = airplane_personal.airplaneid\n" +
                    "INNER join personal ON personal.id = airplane_personal.personalid;");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Object> personalList = new ArrayList<>();
            while (resultSet.next()) {
                Personal personal = new Personal();
                personal.setId(resultSet.getInt("id"));
                personal.setType((Enum) resultSet.getObject("type"));
                personalList.add(personal);

                Integer airplaneId = resultSet.getInt("airplane");
                Integer personalId = resultSet.getInt("personal");
                if(airplaneId != null || personalId != null) {
                    AirplanePersonal airplanePersonal = new AirplanePersonal();
                    airplanePersonal.setAirplane(airplanePersonal.getAirplane());
                    airplanePersonal.setPersonal(airplanePersonal.getPersonal());
                    personalList.add(airplanePersonal);
                }
            }
            return personalList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
