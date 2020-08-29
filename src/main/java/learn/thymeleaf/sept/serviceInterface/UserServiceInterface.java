package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> findAll();
    public User findById(int id);
    public void create(User user);
    public void deleteById(int id);
    public List<User> findByUserName(String keyword);
}
