package repository;

import modle.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
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

    public static void main(String[] args) {
        User user=new User(3,"MInh","Viet nam","khghfh");
        UserRepository i=new UserRepository();
        i.editByID(user);
    }
}
