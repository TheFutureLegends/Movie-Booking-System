package sept.group8.AppointmentBookingSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    //Properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="full_name") private String fullName;
    @Column private String phone;
    @Column private String email;
    @Column private String address;

    //Constructor
    public UserProfile() { }

    public UserProfile(String fullName, String phone, String email, String address) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //toString
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
