package sept.group8.AppointmentBookingSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="reservation_history")
public class ReservationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @OneToMany(mappedBy = "reservationHistory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Column(name="reservation_queue")
//    private final List<Reservation> queueOfReservation = new ArrayList<Reservation>();

//    public void addToQueue(Reservation reservation){
//        queueOfReservation.add(reservation);
//    }
// constructor
    public ReservationHistory() {
    }

    public ReservationHistory(int id) {
        this.id = id;
    }
// getters
    public int getId() {
        return id;
    }

//    public List<Reservation> getQueueOfReservation() {
//        return queueOfReservation;
//    }
// setters
    public void setId(int id) {
        this.id = id;
    }
}
