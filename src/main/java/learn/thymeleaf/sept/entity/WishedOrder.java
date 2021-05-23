package learn.thymeleaf.sept.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="wish_list")
@Getter
@Setter
@ToString
public class WishedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wished_movie_id")
    private Movie wishedMovie;

    public WishedOrder() {
    }

}
