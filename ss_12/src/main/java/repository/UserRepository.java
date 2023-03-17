package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserRepository implements IUseRepository {
    public static final String SELECT_ALL_USER = "select * from is_user;";
    public static final String SELECT_BY_COUNTRY = "select * from is_user where user_country=?";
    public static final String INSERT_USER = "insert into is_user(user_id,user_name,user_country) value(?, ?, ?)";
    public static final String DELETE_BY_ID = "delete from is_user\n where user_id=?;";
    public static final String UPDATE_BY_ID = "update  is_user\n" +
            "set user_id=?,user_name=?,user_country=?\n" +
            "where user_id=?;";
    public static final String SORT_BY_NAME = "select * from is_user order by user_name;";

    public User findByID(int id) {
        List<User> userList = findAll();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> sortByName() {
        List<User> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(SORT_BY_NAME);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("user_email");
                String country = resultSet.getString("user_country");
                list.add(new User(id, name, country, email));
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
        return list;
    }

    public void edit(int id, User users) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(UPDATE_BY_ID);
                statement.setInt(1, users.getId());
                statement.setString(2, users.getName());
                statement.setString(3, users.getCountry());
                statement.setInt(4, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            DBConnection.close();
        }

    }

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
                    String email = resultSet.getString("user_email");
                    User user = new User(id, name, country, email);
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
                statement = connection.prepareStatement(SELECT_BY_COUNTRY);
                statement.setString(1, country);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("user_name");
                    String country1 = resultSet.getString("user_country");
                    String email = resultSet.getString("user_email");
                    user = new User(id, name, country1, email);
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

    public void insert(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_USER);
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            if (connection != null) {
                statement = connection.prepareStatement(DELETE_BY_ID);
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            DBConnection.close();
        }

    }
}
