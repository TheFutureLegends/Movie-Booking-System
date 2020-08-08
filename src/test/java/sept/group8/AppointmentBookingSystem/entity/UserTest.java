package sept.group8.AppointmentBookingSystem.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {User.class, UserProfile.class})
class UserTest {
	@Autowired
	UserProfile up = new UserProfile();
	
	@Autowired
	User u1 = new User();
	User u2 = new User("userName", "password", "role", up);

	@Test
	void testConstructors() {
		assertNotNull(u1.getId());
		assertNotNull(u2.getId());
	}
	
	@Test
	void testGetAndSetId() {
		u1.setId(10);
		assertEquals(10, u1.getId());
		
		u2.setId(11);
		assertEquals(11, u2.getId());
	}

	@Test
	public void testGetAndSetUserName() {
		u1.setUserName("some name");
		assertEquals("some name", u1.getUserName());
		
		u2.setUserName("some name");
		assertEquals("some name", u2.getUserName());
	}

	@Test
	public void testGetAndSetPassword() {
		u1.setPassword("some password");
		assertEquals("some password", u1.getPassword());
		
		u2.setPassword("some password");
		assertEquals("some password", u2.getPassword());
	}

	@Test
	public void testGetAndSetRole() {
		u1.setRole("some role");
		assertEquals("some role", u1.getRole());
		
		u2.setRole("some role");
		assertEquals("some role", u2.getRole());
	}
	
	@Test
	public void testToString() {
		assertNotNull(u1.toString());
		assertNotNull(u2.toString());
	}

}
