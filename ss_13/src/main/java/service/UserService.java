package service;

import modle.User;
import repository.UserRepository;

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
}
