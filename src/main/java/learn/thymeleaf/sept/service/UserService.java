package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.repositories.UserRepository;
import learn.thymeleaf.sept.serviceInterface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository theUserRepository) {
       userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);

        User user = null;

        if (result.isPresent()) {
            user = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find user id - " + id);
        }

        return user;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByUserName(String keyword) {
        return userRepository.findByUserName(keyword);
    }
}