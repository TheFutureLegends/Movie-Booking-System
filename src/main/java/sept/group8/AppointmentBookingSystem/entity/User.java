package sept.group8.AppointmentBookingSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Transient
    @Size(min=5, max=20)
    @Column(name = "password")
    private String password;

    @Column(name="role")
    private String role;

//    @OneToOne(mappedBy = "user")
//    private UserProfile userProfile;

// Constructor
    public User() {
    }

    public User(String userName, @Size(min = 5, max = 20) String password, String role, UserProfile userProfile) {
        this.userName = userName;
        this.password = password;
        this.role = role;
//        this.userProfile = userProfile;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

//    public UserProfile getUserProfile() {
//        return userProfile;
//    }

// Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }

    // toString

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
//                ", userProfile=" + userProfile +
                '}';
    }
}
