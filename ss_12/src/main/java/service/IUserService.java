package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    List<User> findByCountry(String country);
    void insert(User user);
    void delete(int id);
    User findByID(int id);
    void edit(int id,User users);
    List<User> sortByName();
}
