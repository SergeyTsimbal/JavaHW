import dao.MechanicDAO;
import dao.MechanicDAOImpl;
import model.Mechanic;
import model.Service_Stations;
import org.junit.Test;

import java.sql.SQLException;

public class MechanicTest {
    @Test
    public void addMechanic() {

        Service_Stations s = new Service_Stations();
        s.setAddress("Gagarina 4");
        s.setId(1L);
        MechanicDAO dao = new MechanicDAOImpl();
        Mechanic mechanic = new Mechanic();
        mechanic.setName("asd");
        mechanic.setSurname("xcvwt");
        mechanic.setService_stations(s);
        try {
            dao.addMechanic(mechanic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateMechanicTest() {
        Service_Stations s = new Service_Stations();
        s.setId(2L);
        MechanicDAO dao = new MechanicDAOImpl();
        Mechanic mechanic = new Mechanic();
        mechanic.setService_stations(s);
        mechanic.setId(3L);
        mechanic.setName("fufd");
        mechanic.setSurname("cvnn");
        try {
            dao.updateMechanic(mechanic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMechanicByIdTest() {
        MechanicDAO dao = new MechanicDAOImpl();
        try {
            System.out.println(dao.getMechanicById(39L));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteMechanicTest() {
        MechanicDAO dao = new MechanicDAOImpl();
        try {
            dao.deleteMechanic(41L);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
