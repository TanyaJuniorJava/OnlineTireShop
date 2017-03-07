package hibernateFactory;

import dao.implementations.*;
import dao.interfaces.*;

/**
 * Created by Rosh on 05.03.2017.
 */
public class Factory {

    private static UserDao userDao = null;
    private static ProductDao productDao = null;
    private static OrderHistoryDao orderHistoryDao = null;
    private static CommentsDao commentsDao = null;
    private static BasketDao basketDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public ProductDao getProductDao() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public OrderHistoryDao getOrderHistoryDao() {
        if (orderHistoryDao == null) {
            orderHistoryDao = new OrderHistoryDaoImpl();
        }
        return orderHistoryDao;
    }

    public CommentsDao getCommentsDao() {
        if (commentsDao == null) {
            commentsDao = new CommentsDaoImpl();
        }
        return commentsDao;
    }

    public BasketDao getBasketDao() {
        if (basketDao == null) {
            basketDao = new BasketDaoImpl();
        }
        return basketDao;
    }



}

