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

    @Override
    public List<User> findByCountry(String country) {
        return repository.findByCountry(country);
    }
}
