import java.sql.*;

public class CarJDBC {
    static Statement st;
    static Connection con;


    public static void main(String args[]) throws Exception {
        Engine engine = new Engine(1, 3500, 600);
        Car car = new Car(1, "RS-7", "Audi", 140000, engine);
        insertCar(car);
        insertEngine(engine);
        System.out.println(getCarById(1).toString());
        System.out.println(getEngineById(1).toString());
    }

    private static void run() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "csv12csv");
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void insertCar(Car car) throws SQLException {
        run();
        String sql = "INSERT INTO car VALUES('" + car.getId() + "','"
                + car.getModel() + "','" + car.getMake() + "', '" + car.getId() + "', '" + car.getPrice() + "')";
        st.execute(sql);
    }

    static void insertEngine(Engine engine) throws SQLException {
        run();
        String sql = "INSERT INTO engine VALUES('" + engine.getId() + "','"
                + engine.getDisplacement() + "','" + engine.getPower() + "')";
        st.execute(sql);
    }

    static Car getCarById(int id) throws SQLException {
        run();
        ResultSet rs = st.executeQuery("SELECT * FROM car WHERE id = '" + id + "'");
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("model"),
                    rs.getString("make"), rs.getInt("price"));
            return car;
        }
        return null;
    }

    static Engine getEngineById(int id) throws SQLException {
        run();
        ResultSet rs = st.executeQuery("SELECT * FROM engine WHERE id = '" + id + "'");
        while (rs.next()) {
            Engine engine = new Engine(rs.getInt("id"), rs.getInt("displacement"),
                    rs.getInt("power"));
            return engine;
        }
        return null;
    }

    static void deleteCar(int id) throws SQLException {
        run();
        st.execute("DELETE FROM car WHERE id = '" + id + "'");
    }

    static void deleteEngine(int id) throws SQLException {
        run();
        st.execute("DELETE FROM engine WHERE id = '" + id + "'");
    }
}