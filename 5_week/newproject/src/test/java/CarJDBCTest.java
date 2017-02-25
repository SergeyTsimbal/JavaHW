import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class CarJDBCTest {

    @Test
    public void getCarById() throws SQLException {
        CarJDBC carJDBC = new CarJDBC();
        Car testcar = new Car(26, "Test", "Test", 26);
        carJDBC.insertCar(testcar);
        Car car = carJDBC.getCarById(testcar.getId());
        Assert.assertTrue(car.getMake().equals(testcar.getMake()) && car.getId() == testcar.getId());
        carJDBC.deleteCar(car.getId());
    }
    @Test
    public void getEngineById() throws SQLException {
        CarJDBC carJDBC = new CarJDBC();
        Engine testengine = new Engine(4, 2800, 500);
        carJDBC.insertEngine(testengine);
        Engine engine = carJDBC.getEngineById(testengine.getId());
        Assert.assertTrue(engine.getPower() == (testengine.getPower()) && engine.getId() == testengine.getId());
        carJDBC.deleteEngine(engine.getId());
    }
}