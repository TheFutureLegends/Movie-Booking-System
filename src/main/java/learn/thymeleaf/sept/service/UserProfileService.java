package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.repositories.UserProfileRepository;
import learn.thymeleaf.sept.serviceInterface.UserProfileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService implements UserProfileServiceInterface {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository theUserProfileRepository) {
        userProfileRepository = theUserProfileRepository;
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile findById(int id) {
        Optional<UserProfile> result = userProfileRepository.findById(id);

        UserProfile userProfile = null;

        if (result.isPresent()) {
            userProfile = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find user profile id - " + id);
        }

        return userProfile;
    }

    @Override
    public void create(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
    }

    @Override
    public void deleteById(int id) {
        userProfileRepository.deleteById(id);
    }

    @Override
    public List<UserProfile> findByUserProfileName(String keyword) {
        return userProfileRepository.findByUserProfileName(keyword);
    }
}