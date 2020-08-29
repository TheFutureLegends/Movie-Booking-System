package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.User;
import learn.thymeleaf.sept.repositories.UserRepository;
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
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findAll() {
        // declare 2 fake ids
        int id = 1;
        int id2 = 2;
        // create mock user profile 1
        User mockUser1 = new User();
        mockUser1.setId(id);
        mockUser1.setUserName("shit");
        // create mock user profile 2
        User mockUser2 = new User();
        mockUser2.setId(id2);
        mockUser2.setUserName("Shitty Name 2");
        // create mock user profile list
        List<User> mockUserList = new ArrayList<>();
        mockUserList.add(mockUser1);
        mockUserList.add(mockUser2);
        when(userRepository.findAll()).thenReturn(mockUserList);
        // use service to test the list
        UserService service = new UserService(userRepository);
        List<User> result = service.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        // create fake user profile with id 1
        int id = 1;
        User mockUserProfile = new User();
        mockUserProfile.setId(id);
        mockUserProfile.setUserName("Shitty Name");
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(mockUserProfile));
        UserService service = new UserService(userRepository);
        // use service to find the fake user profile
        User result = service.findById(1);
        assertEquals(mockUserProfile, result);
    }

    @Test
    void create() {
        /*UserService service = new UserService(userRepository);
        User fake = new User();
        fake.setId(1);
        fake.setUserName("Fake name");
        int initialSize = service.findAll().size();
        service.create(fake);
        int finalSize = service.findAll().size();
        assertEquals(1, finalSize- initialSize);*/
    }

    @Test
    void deleteById() {
        int id = 1;
        User mockUserProfile = new User();
        mockUserProfile.setId(id);
        mockUserProfile.setUserName("Shitty Name");
        UserService service = new UserService(userRepository);
        // delete user profile's id = 1
        service.deleteById(1);
        assertThrows(RuntimeException.class, () -> service.findById(1));
    }

    @Test
    void findByName() {
        int id = 1;
        User mockUser = new User();
        mockUser.setId(id);
        mockUser.setUserName("Shitty Name");
        List<User> mockUserList = new ArrayList<>();
        mockUserList.add(mockUser);
        when(userRepository.findByUserName("Shitty Name")).thenReturn(mockUserList);
        UserService service = new UserService(userRepository);
        List<User> result = service.findByUserName("Shitty Name");
        assertEquals(result, mockUserList);
    }
}