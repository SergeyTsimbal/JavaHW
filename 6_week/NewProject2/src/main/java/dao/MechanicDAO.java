package dao;

import model.Mechanic;

import java.sql.SQLException;

public interface MechanicDAO {
    void addMechanic(Mechanic mechanic) throws SQLException;
    void updateMechanic(Mechanic mechanic) throws SQLException;
    Mechanic getMechanicById(Long mechanic_id) throws SQLException;
    void deleteMechanic(Long mechanic_id) throws SQLException;
}
