import java.sql.*;

public class CarJDBC {
    private static Statement st;
    private static Connection con;


    public static void main(String args[]) throws Exception {
        Engine engine = new Engine(1, 3500, 600);
        Car car = new Car(1, "RS-7", "Audi", 140000, engine);
        JDBCConnect();
        insertCar(car);
        insertEngine(engine);
        System.out.println(getCarById(1));
        System.out.println(getEngineById(1));
    }

    public static void JDBCConnect() throws SQLException {
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

    public static void insertCar(Car car) throws SQLException {
        String sql = "INSERT INTO car VALUES('" + car.getId() + "','"
                + car.getModel() + "','" + car.getMake() + "', '" + car.getId() + "', '" + car.getPrice() + "')";
        st.execute(sql);
    }

    public static void insertEngine(Engine engine) throws SQLException {
        String sql = "INSERT INTO engine VALUES('" + engine.getId() + "','"
                + engine.getDisplacement() + "','" + engine.getPower() + "')";
        st.execute(sql);
    }

    public static Car getCarById(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM car WHERE id = '" + id + "'");
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("model"),
                    rs.getString("make"), rs.getInt("price"));
            return car;
        }
        return null;
    }

    public static Engine getEngineById(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM engine WHERE id = '" + id + "'");
        while (rs.next()) {
            Engine engine = new Engine(rs.getInt("id"), rs.getInt("displacement"),
                    rs.getInt("power"));
            return engine;
        }
        return null;
    }

    public static void deleteCar(int id) throws SQLException {
        st.execute("DELETE FROM car WHERE id = '" + id + "'");
    }

    public static void deleteEngine(int id) throws SQLException {
        st.execute("DELETE FROM engine WHERE id = '" + id + "'");
    }
}