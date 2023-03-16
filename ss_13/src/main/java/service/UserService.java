package service;

import modle.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    UserRepository userRepository=new UserRepository();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByID(int id) {
        userRepository.deleteByID(id);
    }

    @Override
    public void editByID(User user) {
        userRepository.editByID(user);
    }

    @Override
    public void addUserContraction(User user) throws SQLException {
        userRepository.addUserContraction(user);
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }
}
