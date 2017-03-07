package dao.interfaces;

import dao.entity.Product;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public interface ProductDao {

    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;
    Product getProductById(int id)throws SQLException;
}