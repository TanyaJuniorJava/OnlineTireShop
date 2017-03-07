package dao.interfaces;

import dao.entity.Comments;

import java.sql.SQLException;

/**
 * Created by Rosh on 05.03.2017.
 */
public interface CommentsDao {

    void addComments(Comments comments) throws SQLException;
    void updateComments(Comments comments) throws SQLException;
    public void deleteComments(Comments comments) throws SQLException;
    Comments getCommentsById(int id)throws SQLException;
}

