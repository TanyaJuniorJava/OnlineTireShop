package dao.interfaces;

import dao.entity.User;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public interface UserDao {

    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    User getUserByName(String name) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    Integer getUserIdByName(String name) throws SQLException;
    User getUserById(int id)throws SQLException;

}
