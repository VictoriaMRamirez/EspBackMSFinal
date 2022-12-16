package com.dh.catalog.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
