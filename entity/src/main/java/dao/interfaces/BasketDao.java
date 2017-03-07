package dao.interfaces;

import dao.entity.Basket;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public interface BasketDao {

    void addBasket(Basket basket) throws SQLException;
    void updateBasket(Basket basket) throws SQLException;
    public void deleteBasket(Basket basket) throws SQLException;
    Basket getBasketById(int id)throws SQLException;
}

