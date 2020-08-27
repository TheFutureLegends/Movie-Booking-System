package learn.thymeleaf.sept.service;

import learn.thymeleaf.sept.entity.Reservation;
import learn.thymeleaf.sept.repositories.ReservationRepository;
import learn.thymeleaf.sept.serviceInterface.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationServiceInterface {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository theReservationRepository) {
        reservationRepository = theReservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(int id) {
        Optional<Reservation> result = reservationRepository.findById(id);

        Reservation reservation = null;

        if (result.isPresent()) {
            reservation = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find reservation id - " + id);
        }

        return reservation;
    }

    @Override
    public void create(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findByReservationName(String keyword) {
        return reservationRepository.findByReservationName(keyword);
    }
}
