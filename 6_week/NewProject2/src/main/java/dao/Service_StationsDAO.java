package dao;

import model.Service_Stations;

import java.sql.SQLException;

public interface Service_StationsDAO {
    void addService_Stations(Service_Stations service_stations) throws SQLException;
    void updateService_Stations(Service_Stations service_stations) throws SQLException;
    Service_Stations getCarService_StationsId(Long service_station_id) throws SQLException;
    void deleteService_Stations(Long service_station_id) throws SQLException;
}

