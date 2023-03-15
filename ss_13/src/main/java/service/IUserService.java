package service;

import modle.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void deleteByID(int id);
    void editByID(User user);
}
