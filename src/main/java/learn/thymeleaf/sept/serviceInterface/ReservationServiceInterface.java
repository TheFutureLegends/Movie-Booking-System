package learn.thymeleaf.sept.serviceInterface;

import learn.thymeleaf.sept.entity.Reservation;

import java.util.List;

public interface ReservationServiceInterface {
    public List<Reservation> findAll();
    public Reservation findById(int id);
    public void create(Reservation reservation);
    public void deleteById(int id);
    public List<Reservation> findByReservationName(String keyword);
}
