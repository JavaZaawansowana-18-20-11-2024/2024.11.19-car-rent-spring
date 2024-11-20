package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.Car;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements CarRepositoryInterface {

    private final Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Car> getCars() {
        List<Car> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tcar";
            PreparedStatement statement = this.connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                double price = rs.getDouble("price");
                int year = rs.getInt("year");
                String plate = rs.getString("plate");
                boolean rent = rs.getBoolean("rent");

                result.add(new Car(id, brand, model, price, year, plate, rent));
            }
        } catch (SQLException e) {
            System.out.println("Nie dziala wyciaganie samochodow z bazy !!!");
        }

        return result;
    }

    public void persist(Car car) {
        try {
            String sql = "INSERT INTO tcar (brand, model, price, year, plate, rent) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setDouble(3, car.getPrice());
            statement.setInt(4, car.getYear());
            statement.setString(5, car.getPlate());
            statement.setBoolean(6, car.isRent());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error !!!");
        }
    }

    public void update(Car car) {
        try {
            String sql = "UPDATE tcar SET brand = ?, model = ?, price = ?, year = ?, plate = ?, rent = ? WHERE id = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);

            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setDouble(3, car.getPrice());
            statement.setInt(4, car.getYear());
            statement.setString(5, car.getPlate());
            statement.setBoolean(6, car.isRent());
            statement.setInt(7, car.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
