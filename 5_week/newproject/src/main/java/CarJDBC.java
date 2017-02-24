import java.sql.*;

public class CarJDBC {
    static Statement st;
    static Connection con;

    public static void main(String args[]) {
        Engine engine = new Engine(1, 3500, 500);
        Car car = new Car(1, "RS-7", "Audi", 140000, engine);
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "csv12csv");
            st = con.createStatement();
            st.execute(insertCar(car));
            st.execute(insertEngine(engine));
            System.out.println(getCarById(1).toString());
            System.out.println(getEngineById(1).toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    static String insertCar(Car car) {
        String sql = "INSERT INTO car VALUES('" + car.getId() + "','"
                + car.getModel() + "','" + car.getMake() + "', '" + car.getId() + "', '" + car.getPrice() + "')";
        return sql;
    }

    static String insertEngine(Engine engine) {
        String sql = "INSERT INTO engine VALUES('" + engine.getId() + "','"
                + engine.getDisplacement() + "','" + engine.getPower() + "')";
        return sql;
    }

    static Car getCarById(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM car WHERE id = '" + id + "'");
        while (rs.next()) {
            Car car = new Car(rs.getInt("id"), rs.getString("model"),
                    rs.getString("make"), rs.getInt("price"));
            return car;
        }
        return null;
    }

    static Engine getEngineById(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM engine WHERE id = '" + id + "'");
        while (rs.next()) {
            Engine engine = new Engine(rs.getInt("id"), rs.getInt("displacement"),
                    rs.getInt("power"));
            return engine;
        }
        return null;
    }

}