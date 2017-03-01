package dao;

import model.Mechanic;
import org.hibernate.Session;
import util.HibernateUtil;
import java.sql.SQLException;

public class MechanicDAOImpl implements MechanicDAO{
    public void addMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(mechanic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    public void updateMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(mechanic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Mechanic getMechanicById(Long mechanic_id) throws SQLException {
        Session session = null;
        Mechanic mechanic = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            mechanic = (Mechanic) session.get(Mechanic.class, mechanic_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return mechanic;
    }

    public void deleteMechanic(Long mechanic_id) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Mechanic mechanic = (Mechanic) session.get(Mechanic.class, mechanic_id);
            session.delete(mechanic);
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

