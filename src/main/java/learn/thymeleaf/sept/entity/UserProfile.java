package learn.thymeleaf.sept.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile")
@Getter
@Setter
@ToString
public class UserProfile {
    //Properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="full_name") private String fullName;
    @Column private String phone;
    @Column private String email;
    @Column private String address;
    @OneToMany(mappedBy = "userProfile", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wish_list_id")
    private WishedOrder wishedOrder;

    //Constructor
    public UserProfile() { }

    public UserProfile(String fullName, String phone, String email, String address) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    //add reservations

    public void addReservation(Reservation reservation){
        if (reservations == null){
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        reservation.setUserProfile(this);
    }

    //add wish list

}
