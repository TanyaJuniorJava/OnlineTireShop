package dao.interfaces;

import dao.entity.OrderHistory;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public interface OrderHistoryDao {

    void addOrderHistory(OrderHistory orderHistory) throws SQLException;
    void updateOrderHistory(OrderHistory orderHistory) throws SQLException;
    public void deleteOrderHistory(OrderHistory orderHistory) throws SQLException;
    OrderHistory getOrderHistoryById(int id)throws SQLException;
}
