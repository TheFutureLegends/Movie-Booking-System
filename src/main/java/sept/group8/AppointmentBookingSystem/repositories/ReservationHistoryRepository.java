package sept.group8.AppointmentBookingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sept.group8.AppointmentBookingSystem.entity.ReservationHistory;


public interface ReservationHistoryRepository extends JpaRepository<ReservationHistory,Integer> {
    // CRUD Reservation History DAO, no need more code for CRUD, no implementation class :)
}
