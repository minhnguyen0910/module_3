package service;

import modle.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> findAll();
    void deleteByID(int id);
    void editByID(User user);
    void addUserContraction(User user) throws SQLException;

    void createUser(User user);
}
