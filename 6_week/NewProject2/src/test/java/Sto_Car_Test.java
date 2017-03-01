import dao.CarDAO;
import dao.CarDAOImpl;
import model.Car;
import model.Service_Stations;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Sto_Car_Test {

    @Test
    public void addCarStoTest() throws ParseException {
        CarDAO dao = new CarDAOImpl();
        Car car = new Car();
        car.setMake("mazda");
        car.setModel("x8");
        car.setPrice(146000);
        Service_Stations s = new Service_Stations();
        s.setAddress("Gagarina 774");
        car.add(s);
        SimpleDateFormat format = new SimpleDateFormat("y-MM-dd");
        java.util.Date date = format.parse("2012-12-27");
        car.setDate(date);
        try {
            dao.addCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
