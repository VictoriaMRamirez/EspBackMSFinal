package com.dh.catalog.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@Document(collection = "Series")
public class Serie {

    @Id
    private String serieId = UUID.randomUUID().toString();
    private String name;
    private String genre;
    private List<Season> seasons = new ArrayList<>();
}
