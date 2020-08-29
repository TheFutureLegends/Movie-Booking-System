package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.entity.UserProfile;
import learn.thymeleaf.sept.repositories.ReservationRepository;
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
class ReservationServiceTest {

    @MockBean
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void findAll() {
        // declare 2 fake ids
        int id = 1;
        int id2 = 2;
        // create mock user profile 1
        Reservation mockReservation1 = new Reservation();
        mockReservation1.setId(1);
        mockReservation1.setName("Shitty Name");
        // create mock user profile 2
        Reservation mockReservation2 = new Reservation();
        mockReservation2.setId(id2);
        mockReservation2.setName("Shitty Name 2");
        // create mock user profile list
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(mockReservation1);
        reservationList.add(mockReservation2);
        when(reservationRepository.findAll()).thenReturn(reservationList);
        // use service to test the list
        ReservationService service = new ReservationService(reservationRepository);
        List<Reservation> result = service.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        // create fake user profile with id 1
        int id = 1;
        Reservation mockReservation = new Reservation();
        mockReservation.setId(id);
        mockReservation.setName("Shitty Name");
        Mockito.when(reservationRepository.findById(id)).thenReturn(Optional.of(mockReservation));
        ReservationService service = new ReservationService(reservationRepository);
        // use service to find the fake user profile
        Reservation result = service.findById(1);
        assertEquals(mockReservation, result);
    }

    @Test
    void create() {
    }

    @Test
    void deleteById() {
        int id = 1;
        UserProfile mockReservation = new UserProfile();
        mockReservation.setId(id);
        mockReservation.setFullName("Shitty Name");
        ReservationService service = new ReservationService(reservationRepository);
        // delete user profile's id = 1
        service.deleteById(1);
        assertThrows(RuntimeException.class, () -> service.findById(1));
    }

    @Test
    void findByName() {
        int id = 1;
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setName("Shitty Name");
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation);
        when(reservationRepository.findByReservationName("Shitty Name")).thenReturn(reservationList);
        ReservationService service = new ReservationService(reservationRepository);
        List<Reservation> result = service.findByReservationName("Shitty Name");
        assertEquals(result, reservationList);
    }
}