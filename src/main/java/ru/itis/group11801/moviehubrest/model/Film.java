package ru.itis.group11801.moviehubrest.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String photo;
    private String text;
}
