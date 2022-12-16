package com.dh.catalog.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@Document(collection = "Movies")
public class Movie {

    @Id
    private Long movieId; //String serieId = UUID.randomUUID().toString();
    private String name;
    private String genre;
    private String urlStream;
}
