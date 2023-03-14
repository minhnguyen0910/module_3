package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUseRepository {
    public static final String SELECT_ALL_USER = "select * from user_manage";

    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            if (connection != null) {
                statement = connection.prepareStatement(SELECT_ALL_USER);

                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("user_name");
                    String country = resultSet.getString("user_country");
                    user = new User(id, name, country);
                    userList.add(user);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            DBConnection.close();
        }
        return userList;
    }
}
