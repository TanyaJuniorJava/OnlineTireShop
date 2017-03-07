package dao.implementations;

import dao.entity.User;
import dao.interfaces.UserDao;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by Rosh on 05.03.2017.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }


    @Override
    public void updateUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    @Override
    public User getUserByName(String name) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE name =:paramName");
            query.setParameter("paramName", name);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;
    }


    public Integer getUserIdByName(String name) {
        Integer id = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT idUser FROM User WHERE name =:paramName");
            query.setParameter("paramName", name);
            id = (Integer) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return id;
    }
    public User getUserById(int id) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE idUser =:paramId");
            query.setParameter("paramId", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return user;
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

