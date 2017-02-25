import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class CarJDBCTest {

    @Test
    public void getCarById() throws SQLException {
        Car testcar = new Car(4, "Ford", "Test", 150000);
        CarJDBC.insertCar(testcar);
        Car car = CarJDBC.getCarById(testcar.getId());
        Assert.assertTrue(car.getMake().equals(testcar.getMake()) && car.getId() == testcar.getId());
        CarJDBC.deleteCar(car.getId());
    }

    @Test
    public void getEngineById() throws SQLException {
        Engine testengine = new Engine(6, 2800, 500);
        CarJDBC.insertEngine(testengine);
        Engine engine = CarJDBC.getEngineById(testengine.getId());
        Assert.assertTrue(engine.getPower() == (testengine.getPower()) && engine.getId() == testengine.getId());
        CarJDBC.deleteEngine(engine.getId());
    }
}