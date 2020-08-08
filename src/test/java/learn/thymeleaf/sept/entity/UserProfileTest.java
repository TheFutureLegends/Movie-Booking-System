package learn.thymeleaf.sept.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserProfile.class, Reservation.class})
class UserProfileTest {
	@Autowired
	UserProfile up1 = new UserProfile();
	UserProfile up2 = new UserProfile("fullName", "phone", "email", "address");
	
	@Autowired
	Reservation rev = new Reservation();
	Reservation rev2 = new Reservation();
	List<Reservation> reservations = new ArrayList<Reservation>();

	@Test
	void testConstructors() {
		assertNotNull(up1.getId());
		assertNotNull(up2.getId());
	}
	
	@Test
	void testGetAndSetId() {
		up1.setId(10);
		assertEquals(10, up1.getId());
		
		up2.setId(11);
		assertEquals(11, up2.getId());
	}

	@Test
	public void testGetAndSetFullName() {
		up1.setFullName("some name");
		assertEquals("some name", up1.getFullName());
		
		up2.setFullName("some name");
		assertEquals("some name", up2.getFullName());
	}

	@Test
	public void testGetAndSetPhone() {
		up1.setPhone("19001009");
		assertEquals("19001009", up1.getPhone());
		
		up2.setPhone("19001009");
		assertEquals("19001009", up2.getPhone());
	}

	@Test
	public void testGetAndSetEmail() {
		up1.setEmail("meowmeow@mail.com");
		assertEquals("meowmeow@mail.com", up1.getEmail());
		
		up2.setEmail("meowmeow@mail.com");
		assertEquals("meowmeow@mail.com", up2.getEmail());
	}

	@Test
	public void testGetAndSetAddress() {
		up1.setAddress("some address");
		assertEquals("some address", up1.getAddress());
		
		up2.setAddress("some address");
		assertEquals("some address", up2.getAddress());
	}

	@Test
	public void testAddReservation() {	
		up1.addReservation(rev);
		assertNotNull(up1.getReservations());
		
		up2.addReservation(rev);
		assertNotNull(up2.getReservations());
	}
	
	@Test
	public void testGetAndSetReservations() {
		reservations.add(rev);
		reservations.add(rev2);
		
		up1.setReservations(reservations);
		assertEquals(reservations, up1.getReservations());
		
		up2.setReservations(reservations);
		assertEquals(reservations, up2.getReservations());
	}
	
	
	@Test
	public void testToString() {
		assertNotNull(up1.toString());
		assertNotNull(up2.toString());
	}

}
