package com.dh.serie.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.UUID;

@Getter @Setter
@Document(collection = "Chapters")
public class Chapter {

    @Id
    private String chapterId = UUID.randomUUID().toString();
    private String name;
    private String genre;
    private String urlStream;
}
