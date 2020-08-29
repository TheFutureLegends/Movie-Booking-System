package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.repositories.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserProfileServiceTest {
    @MockBean
    private UserProfileRepository userProfileRepository;

    @InjectMocks
    private UserProfileService userProfileService;

    @Test
    void findAll() {
        // declare 2 fake ids
        int id = 1;
        int id2 = 2;
        // create mock user profile 1
        UserProfile mockUserProfile1 = new UserProfile();
        mockUserProfile1.setId(id);
        mockUserProfile1.setFullName("Shitty Name");
        // create mock user profile 2
        UserProfile mockUserProfile2 = new UserProfile();
        mockUserProfile1.setId(id2);
        mockUserProfile1.setFullName("Shitty Name 2");
        // create mock user profile list
        List<UserProfile> mockUserProfileList = new ArrayList<>();
        mockUserProfileList.add(mockUserProfile1);
        mockUserProfileList.add(mockUserProfile2);
        when(userProfileRepository.findAll()).thenReturn(mockUserProfileList);
        // use service to test the list
        UserProfileService service = new UserProfileService(userProfileRepository);
        List<UserProfile> result = service.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        // create fake user profile with id 1
        int id = 1;
        UserProfile mockUserProfile = new UserProfile();
        mockUserProfile.setId(id);
        mockUserProfile.setFullName("Shitty Name");
        Mockito.when(userProfileRepository.findById(id)).thenReturn(Optional.of(mockUserProfile));
        UserProfileService service = new UserProfileService(userProfileRepository);
        // use service to find the fake user profile
        UserProfile result = service.findById(1);
        assertEquals(mockUserProfile, result);
    }

    @Test
    void create() {
        /*UserProfileService service = new UserProfileService(userProfileRepository);
        UserProfile fake = new UserProfile();
        fake.setId(1);
        fake.setFullName("Fake name");
        int initialSize = service.findAll().size();
        service.create(fake);
//        List<UserProfile> result = service.findAll();
        int finalSize = service.findAll().size();
//        assertNotNull(result);
        assertEquals(1, finalSize- initialSize);*/
    }

    @Test
    void deleteById() {
        int id = 1;
        UserProfile mockUserProfile = new UserProfile();
        mockUserProfile.setId(id);
        mockUserProfile.setFullName("Shitty Name");
        UserProfileService service = new UserProfileService(userProfileRepository);
        // delete user profile's id = 1
        service.deleteById(1);
        assertThrows(RuntimeException.class, () -> service.findById(1));
    }

    @Test
    void findByName() {
        int id = 1;
        UserProfile mockUserProfile = new UserProfile();
        mockUserProfile.setId(id);
        mockUserProfile.setFullName("Shitty Name");
        List<UserProfile> mockUserProfileList = new ArrayList<>();
        mockUserProfileList.add(mockUserProfile);
        when(userProfileRepository.findByUserProfileName("Shitty Name")).thenReturn(mockUserProfileList);
        UserProfileService service = new UserProfileService(userProfileRepository);
        List<UserProfile> result = service.findByUserProfileName("Shitty Name");
        assertEquals(result, mockUserProfileList);
    }
}