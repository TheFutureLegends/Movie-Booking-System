package sept.group8.AppointmentBookingSystem.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Reservation.class, UserProfile.class})
class ReservationTest {
	@Autowired
	Reservation r1 = new Reservation();
	Reservation r2 = new Reservation("name", new Date(System.currentTimeMillis()), "status");
	
	@Autowired
	UserProfile up = new UserProfile();

	@Test
	void testConstructors() {
		assertNotNull(r1.getId());
		assertNotNull(r2.getId());
	}
	
	@Test
	void testGetAndSetId() {
		r1.setId(10);
		assertEquals(10, r1.getId());
		
		r2.setId(11);
		assertEquals(11, r2.getId());
	}

	@Test
	public void testGetAndSetName() {
		r1.setName("some movie name");
		assertEquals("some movie name", r1.getName());
		
		r2.setName("some movie name");
		assertEquals("some movie name", r2.getName());
	}

	@Test
	public void testGetAndSetDateTime() {
		Date currentDate = new Date(System.currentTimeMillis());
		r1.setDateTime(currentDate);
		assertEquals(currentDate, r1.getDateTime());
		
		r2.setDateTime(currentDate);
		assertEquals(currentDate, r2.getDateTime());
	}

	@Test
	public void testGetAndSetStatus() {
		r1.setStatus("some status");
		assertEquals("some status", r1.getStatus());
		
		r2.setStatus("some status");
		assertEquals("some status", r2.getStatus());
	}

	@Test
	public void testGetAndSetUserProfile() {
		r1.setUserProfile(up);
		assertEquals(up, r1.getUserProfile());
		
		r2.setUserProfile(up);
		assertEquals(up, r2.getUserProfile());
	}
	
	@Test
	public void testToString() {
		assertNotNull(r1.toString());
		assertNotNull(r2.toString());
	}

}
