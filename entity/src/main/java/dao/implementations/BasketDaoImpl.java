package dao.implementations;

import dao.entity.Basket;
import dao.interfaces.BasketDao;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public class BasketDaoImpl implements BasketDao {

    @Override
    public void addBasket(Basket basket) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(basket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void updateBasket(Basket basket) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(basket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteBasket(Basket basket) throws SQLException {
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.delete(basket);
                session.getTransaction().commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Basket getBasketById(int id) throws SQLException {
        Basket basket = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Basket WHERE idOrder =:paramId");
            query.setParameter("paramId", id);
            basket = (Basket) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return basket;
    }
}

