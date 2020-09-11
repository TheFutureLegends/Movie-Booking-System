package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAll();
    User findById(int id);
    void create(User user);
    void deleteById(int id);
    List<User> findByUserName(String keyword);

}
