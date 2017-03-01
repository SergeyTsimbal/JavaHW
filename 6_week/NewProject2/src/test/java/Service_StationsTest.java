import dao.Service_StationsDAO;
import dao.Service_StationsDAOImpl;
import model.Service_Stations;
import org.junit.Test;

import java.sql.SQLException;

public class Service_StationsTest {

    @Test
    public void addService_StationsTest() {
        Service_StationsDAO dao = new Service_StationsDAOImpl();
        Service_Stations service_stations = new Service_Stations();
        service_stations.setAddress("Megistralna 242");
        try {
            dao.addService_Stations(service_stations);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateService_StationsTest() {
        Service_StationsDAO dao = new Service_StationsDAOImpl();
        Service_Stations service_stations = new Service_Stations();
        service_stations.setId(3L);
        service_stations.setAddress("Gagarina 5");
        try {
            dao.updateService_Stations(service_stations);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCarService_StationsIdTest() {
        Service_StationsDAO dao = new Service_StationsDAOImpl();
        try {
            System.out.println(dao.getCarService_StationsId(1L));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteService_StationsTest() {
        Service_StationsDAO dao = new Service_StationsDAOImpl();
        try {
            dao.deleteService_Stations(1L);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
