package repository;

import modle.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    public static final String INSERT = "insert into user_table(user_id,user_name,user_country,user_email) value(?,?,?,?)";

    @Override
    public List<User> findAll() {
        Connection connection=DBConnection.getConnection();
        CallableStatement statement=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<>();
        User user=null;
        if (connection!=null){
            try {
                statement=connection.prepareCall("call display_user()");
                resultSet=statement.executeQuery();
                while (resultSet.next()){
                    int id=resultSet.getInt("user_id");
                    String name=resultSet.getString("user_name");
                    String email=resultSet.getString("user_email");
                    String country=resultSet.getString("user_country");
                    user=new User(id,name,email,country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return userList;
    }

    @Override
    public void deleteByID( int id) {
       Connection connection=DBConnection.getConnection();
       CallableStatement statement=null;
       if (connection!=null){
           try {
               statement=connection.prepareCall("call delete_user(?)");
               statement.setInt(1,id);
               statement.executeUpdate();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }finally {
               try {
                   statement.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
               DBConnection.close();
           }
       }
    }

    @Override
    public void editByID(User user) {
       Connection connection=DBConnection.getConnection();
       CallableStatement statement=null;
       if (connection!=null){
           try{
               statement=connection.prepareCall("call edit_user(?,?,?,?)");
               statement.setInt(1,user.getId());
               statement.setString(2, user.getName());
               statement.setString(3, user.getEmail());
               statement.setString(4, user.getCountry());
               statement.executeUpdate();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }finally {
               try {
                   statement.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
               DBConnection.close();
           }
       }
    }
    public void addUserContraction(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.executeUpdate();

            savepoint = connection.setSavepoint();

            preparedStatement = connection.prepareStatement("");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (savepoint != null){
                connection.rollback(savepoint);
                connection.commit();
            }
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void createUser(User user) {
        Connection connection=DBConnection.getConnection();
        PreparedStatement statement=null;
        if (connection!=null){
            try {
                statement=connection.prepareStatement(INSERT);
                statement.setInt(1,user.getId());
                statement.setString(2,user.getName());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }
}
