package com.dh.movie.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", unique = true, nullable = false)
    private Long movieId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "genre", nullable = false, length = 50)
    private String genre;

    @Column(name = "url_stream", nullable = false, length = 250)
    private String urlStream;
}
