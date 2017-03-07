package main;

import dao.entity.*;
import dao.implementations.UserDaoImpl;
import dao.interfaces.UserDao;
import hibernateFactory.Factory;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rosh on 05.03.2017.
 */
public class Main {

        public static void main(String[] args) throws SQLException {

            // User u1 = new User("Vasya", "tasdhs@gmail.com", "fjkhjshsf");
            User u2 = new User("Petya", "ajsdjkfr@gmail.com", "weuirui");

            Product prod1 = new Product("tire", "Toyo", "Taurus 401 Highperformance", "225/45 R17");
            Set<Product> product1 = new HashSet<Product>();
            product1.add(prod1);
            OrderHistory ordHist1 = new OrderHistory(7032017, u2);
            Basket bask1 = new Basket(product1, 4, 4640, ordHist1, u2);
            Set<Basket> basket1 = new HashSet<Basket>();
            basket1.add(bask1);
            Comments comments1 = new Comments(2032017, "dfjfghgeeydf", u2, prod1);



           // Factory.getInstance().getUserDao().addUser(u1);
            Factory.getInstance().getUserDao().addUser(u2);
            Factory.getInstance().getProductDao().addProduct(prod1);
            Factory.getInstance().getOrderHistoryDao().addOrderHistory(ordHist1);
            Factory.getInstance().getBasketDao().addBasket(bask1);
            Factory.getInstance().getCommentsDao().addComments(comments1);

        }
}
