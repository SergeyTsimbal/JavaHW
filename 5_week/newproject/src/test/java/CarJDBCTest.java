import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CarJDBCTest {

    static Car car;
    static Engine engine;
    CarJDBC carJDBC;

    @Before
    public void run() {
        carJDBC = new CarJDBC();
    }


    @Test()
    public void insertCar() throws Exception {
        car = new Car(1, "RS-7", "Audi", 4);
        String sql = "INSERT INTO car VALUES('" + car.getId() + "','"
                + car.getModel() + "','" +  car.getMake() + "', '" +car.getId() + "', '" + car.getPrice() + "')";
        String s = carJDBC.insertCar(car);
        Assert.assertTrue(s.equals(sql));
    }

    @Test
    public void insertEngine() throws Exception {
        engine = new Engine(4, 2800, 500);
        String sql = "INSERT INTO engine VALUES('" + engine.getId() + "','"
                + engine.getDisplacement() + "','" + engine.getPower() + "')";
        String s = carJDBC.insertEngine(engine);
        Assert.assertTrue(s.equals(sql));
    }

    @Test
    public void getCarById() throws Exception {
        Assert.assertEquals(car.getId(), 1);
    }


    @Test
    public void getEngineById() throws Exception {
        Assert.assertEquals(engine.getId(), 4);

    }


}