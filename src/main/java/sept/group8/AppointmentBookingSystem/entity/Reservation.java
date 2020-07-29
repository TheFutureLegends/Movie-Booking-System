package sept.group8.AppointmentBookingSystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    //Properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name") private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile", referencedColumnName = "id")
    private UserProfile userProfile;

    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateTime;

    @Column
    private String status;

    //Constructors
    public Reservation() { }

    public Reservation(String userName, UserProfile userProfile, Date dateTime, String status) {
        this.userName = userName;
        this.userProfile = userProfile;
        this.dateTime = dateTime;
        this.status = status;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public UserProfile getUserProfile() { return userProfile; }
    public Date getDateTime() { return dateTime; }
    public String getStatus() {
        return status;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //toString
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userProfile=" + userProfile +
                ", dateTime=" + dateTime +
                ", status='" + status + '\'' +
                '}';
    }
}