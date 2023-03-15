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

    @Override
    public void insert(User user) {
        repository.insert(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public User findByID(int id) {
        return repository.findByID(id);
    }

    @Override
    public void edit(int id, User users) {
        repository.edit(id,users);
    }

    @Override
    public List<User> sortByName() {
       return repository.sortByName();
    }
}
