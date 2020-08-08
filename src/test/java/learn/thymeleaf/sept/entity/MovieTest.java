package learn.thymeleaf.sept.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Movie.class})
class MovieTest {
	
	@Autowired
	Movie m1 = new Movie();
	Movie m2 = new Movie("picture", "movieName", "directors", "cast", "category", new Date(System.currentTimeMillis()), 120, "language", "rated", "description");

	@Test
	void testConstructors() {
		assertNotNull(m1.getId());
		assertNotNull(m2.getId());
	}
	
	@Test
	void testGetAndSetId() {
		m1.setId(10);
		assertEquals(10, m1.getId());
		
		m2.setId(11);
		assertEquals(11, m2.getId());
	}
	
	@Test
	void testGetAndSetCoverPicture() {
		m1.setCoverPicture("some picture");
		assertEquals("some picture", m1.getCoverPicture());
		
		m2.setCoverPicture("some picture");
		assertEquals("some picture", m2.getCoverPicture());
	}

	@Test
	public void testGetAndSetMovieName() {
		m1.setMovieName("some movie name");
		assertEquals("some movie name", m1.getMovieName());
		
		m2.setMovieName("some movie name");
		assertEquals("some movie name", m2.getMovieName());
	}

	@Test
	public void testGetAndSetDirectors() {
		m1.setDirectors("some directors");
		assertEquals("some directors", m1.getDirectors());
		
		m2.setDirectors("some directors");
		assertEquals("some directors", m2.getDirectors());
	}

	@Test
	public void testGetAndSetCast() {
		m1.setCast("some cast");
		assertEquals("some cast", m1.getCast());
		
		m2.setCast("some cast");
		assertEquals("some cast", m2.getCast());
	}

	@Test
	public void testGetAndSetCategory() {
		m1.setCategory("some category");
		assertEquals("some category", m1.getCategory());
		
		m2.setCategory("some category");
		assertEquals("some category", m2.getCategory());
	}

	@Test
	public void testGetAndSetPremiere() {
		Date currentDate = new Date(System.currentTimeMillis());
		m1.setPremiere(currentDate);
		assertEquals(currentDate, m1.getPremiere());
		
		m2.setPremiere(currentDate);
		assertEquals(currentDate, m2.getPremiere());
	}

	@Test
	public void testGetAndSetDuration() {
		m1.setDuration(200);
		assertEquals(200, m1.getDuration());
		
		m2.setDuration(200);
		assertEquals(200, m2.getDuration());	
	}

	@Test
	public void testGetAndSetLanguage() {
		m1.setLanguage("Japanese");
		assertEquals("Japanese", m1.getLanguage());
		
		m2.setLanguage("Japanese");
		assertEquals("Japanese", m2.getLanguage());
	}

	@Test
	public void testGetAndSetRated() {
		m1.setRated("18+");
		assertEquals("18+", m1.getRated());
		
		m2.setRated("18+");
		assertEquals("18+", m2.getRated());
	}

	@Test
	public void testGetandSetDescription() {
		m1.setDescription("Nothing to see here, lol!!!");
		assertEquals("Nothing to see here, lol!!!", m1.getDescription());
		
		m2.setDescription("Nothing to see here, lol!!!");
		assertEquals("Nothing to see here, lol!!!", m2.getDescription());
	}
	
	@Test
	public void testToString() {
		assertNotNull(m1.toString());
		assertNotNull(m2.toString());
	}

}
