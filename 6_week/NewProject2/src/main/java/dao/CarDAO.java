package dao;

import model.Car;

import java.sql.SQLException;

public interface CarDAO {
    void addCar(Car car) throws SQLException;
    void updateCar(Car car) throws SQLException;
    Car getCarById(Long car_id) throws SQLException;
    void deleteCar(Long car_id) throws SQLException;
}