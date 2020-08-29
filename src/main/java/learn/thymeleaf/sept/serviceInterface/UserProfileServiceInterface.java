package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.UserProfile;

import java.util.List;

public interface UserProfileServiceInterface {
    public List<UserProfile> findAll();
    public UserProfile findById(int id);
    public void create(UserProfile userProfile);
    public void deleteById(int id);
    public List<UserProfile> findByUserProfileName(String keyword);
}
