package sept.group8.AppointmentBookingSystem.serviceInterface;

import sept.group8.AppointmentBookingSystem.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> findAll();
    public User findById(int id);
    public void create(User user);
    public void deleteById(int id);
}
