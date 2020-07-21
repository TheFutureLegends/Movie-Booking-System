package sept.group8.AppointmentBookingSystem.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    enum Status {
        Accepted,
        Cancelled,
        Pending,
        Finished
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "location")
    private String location;

    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateTime;

    @Column(name = "status")
    private String status;

//    @ManyToOne @JsonIgnore
//    private ReservationHistory reservationHistory;

    public Reservation() {
    }

    public Reservation(String name, String contact, String location, Date dateTime, String status) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.dateTime = dateTime;
        this.status = status;
    }
// getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getLocation() {
        return location;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

//    public ReservationHistory getReservationHistory() {
//        return reservationHistory;
//    }
// setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public void setReservationHistory(ReservationHistory reservationHistory) {
//        this.reservationHistory = reservationHistory;
//    }

// to string

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", location='" + location + '\'' +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
//                ", reservationHistory=" + reservationHistory +
                '}';
    }
}
