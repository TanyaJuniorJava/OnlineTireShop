package dao.implementations;

import dao.entity.Comments;
import dao.interfaces.CommentsDao;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public class CommentsDaoImpl implements CommentsDao {
    @Override
    public void addComments(Comments comments) throws SQLException {
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.save(comments);
                session.getTransaction().commit();
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void updateComments(Comments comments) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(comments);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteComments(Comments comments) throws SQLException {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(comments);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Comments getCommentsById(int id) throws SQLException {
        Comments comments = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Comments WHERE idComments =:paramId");
            query.setParameter("paramId", id);
            comments = (Comments) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return comments;
    }
}
