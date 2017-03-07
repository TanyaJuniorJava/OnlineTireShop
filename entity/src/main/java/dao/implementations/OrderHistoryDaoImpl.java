package dao.implementations;

import dao.entity.OrderHistory;
import dao.interfaces.OrderHistoryDao;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public class OrderHistoryDaoImpl implements OrderHistoryDao {

    @Override
    public void addOrderHistory(OrderHistory orderHistory) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(orderHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(orderHistory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteOrderHistory(OrderHistory orderHistory) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(orderHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public OrderHistory getOrderHistoryById(int id) throws SQLException {
        OrderHistory orderHistory = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM OrderHistory WHERE idOrderHistory =:paramId");
            query.setParameter("paramId", id);
            orderHistory = (OrderHistory) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return orderHistory;
    }
}
