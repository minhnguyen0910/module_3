package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUseRepository {
    public static final String SELECT_ALL_USER = "select * from is_user;";

    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            if (connection != null) {
                statement = connection.prepareStatement(SELECT_ALL_USER);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("user_name");
                    String country = resultSet.getString("user_country");
                    User user = new User(id, name, country);
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

    @Override
    public List<User> findByCountry(String country) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        List<User> userList = new ArrayList<>();
        try {
            if (connection != null) {
                statement = connection.prepareStatement("select * from is_user where user_country=?");
                statement.setString(1, country);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("user_name");
                    String country1 = resultSet.getString("user_country");
                    user = new User(id, name, country1);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    public static void main(String[] args) {
        UserRepository i=new UserRepository();
        System.out.println(i.findByCountry("Viet Nam"));
    }
}
