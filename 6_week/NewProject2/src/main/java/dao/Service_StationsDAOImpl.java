package dao;

import model.Service_Stations;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;


public class Service_StationsDAOImpl implements Service_StationsDAO{
    public void addService_Stations(Service_Stations service_stations) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(service_stations);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public void updateService_Stations(Service_Stations service_stations) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(service_stations);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Service_Stations getCarService_StationsId(Long service_station_id) throws SQLException {
        Session session = null;
        Service_Stations service_stations = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            service_stations = (Service_Stations) session.get(Service_Stations.class, service_station_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return service_stations;
    }

    public void deleteService_Stations(Long service_station_id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Service_Stations service_stations = (Service_Stations) session.get(Service_Stations.class, service_station_id);
            session.delete(service_stations);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}

