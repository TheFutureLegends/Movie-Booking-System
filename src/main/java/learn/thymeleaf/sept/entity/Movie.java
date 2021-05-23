package learn.thymeleaf.sept.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@ToString
public class Movie {
    //Properties
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cover_picture") private String coverPicture;
    @Column(name = "movie_name") private String movieName;
    @Column private String directors;
    @Column private String cast;
    @Column private String category;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date premiere;

    @Column private int duration;
    @Column private String language;
    @Column private String rated;
    @Column private String description;
    @Column(name = "movie_start_time")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date movieStartTime;
    @Column(name = "movie_available_seat")
    private int movieAvailableSeat;

    @OneToMany(mappedBy = "wishedMovie", fetch = FetchType.LAZY)
    private List<WishedOrder> wishedOrderList;

    public Movie() {
    }

    public Movie(String coverPicture, String movieName, String directors, String cast, String category, Date premiere, int duration, String language, String rated, String description, Date movieStartTime, int movieAvailableSeat) {
        this.coverPicture = coverPicture;
        this.movieName = movieName;
        this.directors = directors;
        this.cast = cast;
        this.category = category;
        this.premiere = premiere;
        this.duration = duration;
        this.language = language;
        this.rated = rated;
        this.description = description;
        this.movieStartTime = movieStartTime;
        this.movieAvailableSeat = movieAvailableSeat;
    }

    //add reservations

    public void addOrder(WishedOrder wishedOrder){
        if (wishedOrderList == null){
            wishedOrderList = new ArrayList<>();
        }
        wishedOrderList.add(wishedOrder);
        wishedOrder.setWishedMovie(this);
    }
}
