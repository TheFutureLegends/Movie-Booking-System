package learn.thymeleaf.sept.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_profile_id")
    private UserProfile userProfile;
    //Constructors
    public Reservation() {}

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