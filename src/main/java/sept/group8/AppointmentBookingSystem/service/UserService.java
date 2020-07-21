package sept.group8.AppointmentBookingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sept.group8.AppointmentBookingSystem.repositories.UserRepository;
import sept.group8.AppointmentBookingSystem.serviceInterface.UserServiceInterface;
import sept.group8.AppointmentBookingSystem.entity.User;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user;
        if (result.isPresent()){
            user = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find user -" + id);
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
}
