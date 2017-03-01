import dao.CarDAO;
import dao.CarDAOImpl;

import model.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CarTest {

    @Test
    public void addCarTest() throws ParseException {
        CarDAO dao = new CarDAOImpl();
        Car car = new Car();
        car.setMake("bmw");
        car.setModel("x6");
        car.setPrice(156000);
        SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
        java.util.Date date = format.parse("2012-12-27");
        car.setDate(date);
        try {
            dao.addCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateCarTest() throws ParseException {
        CarDAO dao = new CarDAOImpl();
        Car car = new Car();
        car.setId(2L);
        car.setMake("audi");
        car.setModel("rs7");
        car.setPrice(300);
        SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
        java.util.Date date = format.parse("2013-12-27");
        car.setDate(date);
        try {
            dao.updateCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCarByIdTest() {
        CarDAO dao = new CarDAOImpl();
        try {
            System.out.println(dao.getCarById(2L));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteCarTest() {
        CarDAO dao = new CarDAOImpl();
        try {
            dao.deleteCar(11L);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
