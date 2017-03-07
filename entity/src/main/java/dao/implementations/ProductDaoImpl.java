package dao.implementations;

import dao.entity.Product;
import dao.interfaces.ProductDao;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public void addProduct(Product product) throws SQLException {
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.save(product);
                session.getTransaction().commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.update(product);
                session.getTransaction().commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        Product product = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Product WHERE idProduct =:paramId");
            query.setParameter("paramId", id);
            product = (Product) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return product;
    }
}

