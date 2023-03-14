package service;

import model.User;
import repository.IUseRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    IUseRepository repository=new UserRepository();
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
