package repository;

import modle.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    void deleteByID(int id);
    void editByID(User user);
}
