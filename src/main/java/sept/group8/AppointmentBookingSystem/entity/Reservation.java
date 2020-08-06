package sept.group8.AppointmentBookingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    //Properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name") private String name;

    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateTime;

    @Column
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "u_profile_id")
    private UserProfile userProfile;
    //Constructors
    public Reservation() { }

    public Reservation(String name, Date dateTime, String status) {
        this.name = name;
        this.dateTime = dateTime;
        this.status = status;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Date getDateTime() { return dateTime; }
    public String getStatus() {
        return status;
    }
    public UserProfile getUserProfile() { return userProfile; }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    //toString
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationName1='" + name + '\'' +
                ", userProfile=" + userProfile +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                '}';
    }
}